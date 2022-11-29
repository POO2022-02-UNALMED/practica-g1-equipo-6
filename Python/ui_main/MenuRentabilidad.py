import tkinter as tk
from tkinter import ttk
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.manejoErrores.Validador import Validador
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Servicio import Servicio
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from tkinter import messagebox


class MenuRentabilidad(tk.Frame):
    def __init__(self, master, contenedor):
        tk.Frame.__init__(self, contenedor)

        self.master = master

        self.logo = self.master.cargarImagen("bus")
        self.sidebar = ttk.Frame(self, borderwidth="2", relief="raised")
        self.main = ttk.Frame(self, borderwidth="2")

        self.sidebar.pack(side="left", fill="y")
        self.main.pack(side="right", fill="both", expand=True)

        # Creacion de sidebar
        self.crearSideBar()

    def crearSideBar(self):
        lblImage = ttk.Label(self.sidebar, image=self.logo)
        lblBrand = ttk.Label(
            self.sidebar, text="TransPOOrte", font=("Segoe UI", 15))
        btnComprarTiquete = ttk.Button(
            self.sidebar, 
            text="Visualizar Ocupacion", 
            command=lambda: self.filtraViaje("Visualizar Ocupacion", "VISUALIZAR OCUPACION")
        )
        btnAdquirirServicio = ttk.Button(
            self.sidebar, 
            text="Rentabilidad", 
            command=lambda: self.filtraViaje("Calcular Rentabilidad", "CALCULAR RENTABILIDAD"))
        
        
        # Pack widgets
        lblImage.pack()
        lblBrand.pack(padx="5", pady=(0, 60))
        btnComprarTiquete.pack(fill="x", padx="5", pady="3")
        btnAdquirirServicio.pack(fill="x", padx="5", pady="3")
    
    def filtraViaje(self, titulo, accion):
        self.master.limpiarFrame(self.main)
        lblMensajeInicio = ttk.Label(self.main, text=titulo, font=("Segoe UI", 20))
        lblMensajeInicio.pack()

        cmbDestinoVar = tk.StringVar()
        cmbOrigenVar = tk.StringVar()

        def submit():
            destinoViaje = cmbDestinoVar.get()
            origenViaje = cmbOrigenVar.get()
            validador = Validador()

            validador.validarCampoVacio(destinoViaje, origenViaje)
            validador.validarOrigenDestino(destinoViaje, origenViaje)
            if validador.getValidacion():
                validador.setValidacion(False)
                validador.validarExisteViaje(origenViaje, destinoViaje, Viaje.getViajes())


            if validador.getValidacion():
                viajesFiltrados = list(
                    filter(
                        lambda viaje: viaje.getOrigen() == origenViaje
                        and viaje.getDestino() == destinoViaje,
                        Viaje.getViajes(),
                    )
                )
                self.escogerViaje(viajesFiltrados, accion)
        
        lblDestino = ttk.Label(self.main, text="Destino")
        cmbDestino = ttk.Combobox(self.main, values= Viaje.getLugares(), textvariable= cmbDestinoVar)

        lblOrigen = ttk.Label(self.main, text="Origen")
        cmbOrigen = ttk.Combobox(self.main, values= Viaje.getLugares(), textvariable= cmbOrigenVar)


        lblOrigen.pack()
        cmbOrigen.pack()
        lblDestino.pack()
        cmbDestino.pack()

        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()

    def escogerViaje(self, viajes, accion):
        self.master.limpiarFrame(self.main)
        lblTitulo = ttk.Label(self.main, text = "Viajes disponibles").pack(pady = (0,30))
        rbdViajeVar = tk.StringVar()
        lblResultadoVar = tk.StringVar()
        lblResultado = ttk.Label(self.main, text="")

        def submit(accion):
            viajeVar = rbdViajeVar.get()
            validador = Validador()
            validador.validarCampoVacio(viajeVar)

            if validador.getValidacion():
                viajeFinal = None
                for viaje in viajes: 
                    if viaje.getId() == int(viajeVar):
                        viajeFinal = viaje
                        break

                if accion == "VISUALIZAR OCUPACION":
                    tiquetesViaje = []
                    for tiquete in viajeFinal.getTiquetesTodos():
                        if ((tiquete.getId() == int(viajeVar)) and (tiquete.getEstado() == False)):
                            tiquetesViaje.append(tiquete)
                    porcentaje = ((((viajeFinal.getBus().getCapacidad()) - len(tiquetesViaje))*100))/viajeFinal.getBus().getCapacidad()
                    messagebox.showinfo(title=accion, message=f"La ocupacion de este viaje es de {porcentaje}%")

                elif accion == "CALCULAR RENTABILIDAD":
                    valorTiquetes = 0
                    sillasOcupadas = 0
                    for tiqueteViaje in viajeFinal.getTiquetesTodos():
                        if tiqueteViaje.getEstado() and tiqueteViaje.getId() == int(viajeVar):
                            valorTiquetes += tiqueteViaje.getValor()
                            sillasOcupadas += 1
                        else:
                            continue
                    txt1 = "La ocupacion del vehiculo de este viaje fue del : " + str((100 / len(Viaje.getTiquetesTodos()) * sillasOcupadas)) \
                            + "%" + "," + " con " + str(viaje.getBus().getCapacidad()) \
                            + " sillas disponibles en total. \n"
                    txt2 = "Para este viaje se genero por tiquetes $" + str(valorTiquetes) + " y su costo de operacion fue de " \
                            + str(viaje.getCostoViaje()) + " con una utilidad de " + str(valorTiquetes - viaje.getCostoViaje())+ "\n"
                    msg = txt1 + "\n" +txt2
                    messagebox.showinfo(title=accion, message=msg)
        for viaje in viajes: 
            ttk.Radiobutton(self.main, text = viaje, value = viaje.getId(), variable= rbdViajeVar).pack()
        
        btnViaje = ttk.Button(self.main, text = "Submit", command = lambda: submit(accion) )
        btnViaje.pack()
        lblResultado.pack()