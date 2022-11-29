import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from gestor_aplicacion.clasesPrincipales.Conductor import Conductor
from gestor_aplicacion.manejoErrores.Validador import Validador
from gestor_aplicacion.clasesHerencia.Ejecutivo import Ejecutivo
from gestor_aplicacion.clasesHerencia.EuroVans import EuroVans
from gestor_aplicacion.clasesHerencia.TecnoVans import TecnoVans
from funcionalidades.administrarVehiculos import *
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from tkinter import messagebox


class MenuVehiculo(tk.Frame):
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
        self.agregarVehiculo()

    def crearSideBar(self):
        lblImage = ttk.Label(self.sidebar, image=self.logo)
        lblBrand = ttk.Label(
            self.sidebar, text="TransPOOrte", font=("Segoe UI", 15))
        btnCrearVehiculo = ttk.Button(
            self.sidebar, text="Agregar vehiculo", command=self.agregarVehiculo)
        btnEliminarVehiculo  = ttk.Button(
            self.sidebar, text="Eliminar vehiculo")
        btnCambiarConductor = ttk.Button(
            self.sidebar, text="Cambiar conductor\n del vehiculo", command = self.modificarConductor)
        btnMostrarVehiculos = ttk.Button(
            self.sidebar, text= "Mostrar vehiculos\n y sillas", command = self.mostrarVehiculos)

        # Pack widgets
        lblImage.pack()
        lblBrand.pack(padx="5", pady=(0, 25))
        btnCrearVehiculo.pack(fill="x", padx="5", pady="3")
        btnEliminarVehiculo.pack(fill="x", padx="5", pady="3")
        btnCambiarConductor.pack(fill="x", padx="5", pady="3") #justify= "center"
        btnMostrarVehiculos.pack(fill= "x", padx= "5", pady= "3")

    def agregarVehiculo(self):
        self.master.limpiarFrame(self.main)
        
        escogerVehiculoVar = tk.StringVar()
        entryPlacaVar = tk.StringVar()
        entryNombreVar = tk.StringVar()
        entryCedulaVar = tk.StringVar()
        entryCelularVar = tk.StringVar()
        entrySalarioVar = tk.StringVar()

        def submit():
            tipoVeihiculo = escogerVehiculoVar.get()
            placaVehiculo = entryPlacaVar.get()
            nombreConductor = entryNombreVar.get()
            cedulaConductor = entryCedulaVar.get()
            celularConductor = entryCelularVar.get()
            saliarioConductor = entrySalarioVar.get()

            validador = Validador()
            validador.validarCampoVacio(tipoVeihiculo, placaVehiculo, nombreConductor, cedulaConductor,celularConductor,saliarioConductor)
            if (validador.getValidacion()):
                validador.validarCampoNumerico(cedulaConductor)

            if validador.getValidacion():
                conductor = Conductor(nombreConductor, cedulaConductor, celularConductor, saliarioConductor)
                if tipoVeihiculo == "Ejecutivo":
                    bus = Ejecutivo(placaVehiculo,conductor,[])

                elif tipoVeihiculo == "TecnoVans":
                    bus = TecnoVans(placaVehiculo,conductor,[])

                elif tipoVeihiculo == "EuroVans":
                    bus = EuroVans(placaVehiculo,conductor,[])

                for i in Conductor.getConductores(): 
                    print(i)
                for i in Bus.getBuses(): 
                    print(i)
                messagebox.showinfo(message="Vehiculo creado", title="Estado")


        lblTitulo = ttk.Label(self.main, text="Formulario de registro", font=("Segoe UI", 20))
        lblTypo = ttk.Label(self.main, text="Typo de vehiculo")

        lblPlaca = ttk.Label(self.main, text="Placa del vehiculo")
        entryPlaca = ttk.Entry(self.main, textvariable=entryPlacaVar)
        lblNombre = ttk.Label(self.main, text="Nombre del conductor")
        entryNombre = ttk.Entry(self.main, textvariable=entryNombreVar)
        lblCedula = ttk.Label(self.main, text="Cedula del conductor")
        entryCedula = ttk.Entry(self.main, textvariable=entryCedulaVar)
        lblCelular = ttk.Label(self.main, text="Celular del conductor")
        entryCelular = ttk.Entry(self.main, textvariable=entryCelularVar)
        lblSalario= ttk.Label(self.main, text="Salario del conductor")
        entrySalario = ttk.Entry(self.main, textvariable=entrySalarioVar)
        
        lblTitulo.pack(pady=(0, 20))
        lblTypo.pack()

        busENombre = Ejecutivo.__name__
        busECapacidad =  24
        textEVehiculo = ("Vehiculo: "+busENombre+"\nCapacidad: "+str(busECapacidad))
        ttk.Radiobutton(self.main, text = textEVehiculo, value = busECapacidad, variable= escogerVehiculoVar).pack()

        busEuNombre = EuroVans.__name__
        busEuCapacidad =  16
        textEuVehiculo = ("Vehiculo: "+busEuNombre+"\nCapacidad: "+ str(busEuCapacidad))
        ttk.Radiobutton(self.main, text = textEuVehiculo, value = busEuCapacidad, variable= escogerVehiculoVar).pack()

        busTNombre = TecnoVans.__name__
        busTCapacidad =  20
        textTVehiculo = ("Vehiculo: "+busTNombre+"\nCapacidad: "+str(busTCapacidad))
        ttk.Radiobutton(self.main, text = textTVehiculo, value = busTCapacidad, variable= escogerVehiculoVar).pack()
        
        lblPlaca.pack() 
        entryPlaca.pack()   
        lblNombre.pack()
        entryNombre.pack()
        lblCedula.pack()
        entryCedula.pack()
        lblCelular.pack()
        entryCelular.pack()
        lblSalario.pack()
        entrySalario.pack()        

        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()

    def volverBuses(self):
        self.master.limpiarFrame(self.main)
        self.mostrarVehiculos()

    def ejecutivo(self):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25}".
                    format('Placa','Conductor'), justify= "center").pack(pady = (0,15))
        for buses in Bus.getBuses():
            if buses.getCodigo() == 150:
                ttk.Label(self.main, text = "{:<20} {:<25}".
                    format(str(buses._placa), str(buses.getConductor().getNombre()))).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.volverBuses()).pack()

    def euroVans(self):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25} ".
                    format('Placa','Conductor'), justify= "center").pack(pady = (0,15))
        for buses in Bus.getBuses():
            if buses.getCodigo() == 250:
                ttk.Label(self.main, text = "{:<20} {:<25}".
                    format(str(buses._placa), str(buses.getConductor().getNombre()))).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.volverBuses()).pack()

    def tecnoVans(self):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25}".
                    format('Placa','Conductor'), justify= "center").pack(pady = (0,15))
        for buses in Bus.getBuses():
            if buses.getCodigo() == 200:
                # imprime los viajes que coinciden con la coondicion(Ejecutivo)
                ttk.Label(self.main, text = "{:<20} {:<25}".
                format((str(buses._placa)), str(buses.getConductor().getNombre()))).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.volverBuses()).pack()

    def mostrarVehiculos(self):
        self.master.limpiarFrame(self.main)
        lblMensajeInicio = ttk.Label(self.main, text="Buses", font=("Segoe UI", 20))
        lblEjecutivo = ttk.Label(self.main, text = "Lista por tipo de bus", anchor= "center")
        btnEjecutivo = ttk.Button(self.main, text = "Ejecutivo", command= lambda: self.ejecutivo())
        btnEuroVans = ttk.Button(self.main, text = "EuroVans", command= lambda: self.euroVans())
        btnTecnovans = ttk.Button(self.main, text = "TecnoVans", command= lambda: self.tecnoVans())
        
        lblMensajeInicio.pack()
        lblEjecutivo.pack()
        btnEjecutivo.pack()
        btnEuroVans.pack()
        btnTecnovans.pack()

    def modificarConductor(self):
        self.master.limpiarFrame(self.main)
        entryDocumentoVar = tk.StringVar()
        entrySillaNuevaVar = tk.StringVar()

        def submit():
            numDocumento = entryDocumentoVar.get()
            sillaNueva = entrySillaNuevaVar.get()
            validador = Validador()

            validador.validarCampoVacio(numDocumento, sillaNueva)
            if validador.getValidacion():
                validador.validarCampoNumerico(numDocumento)
            validador.validarDocumento(numDocumento, Tiquete)
            validador.validarDisponibleSilla(sillaNueva, Bus)
            if validador.getValidacion():
                validador.setValidacion(False)
                validador.validarExistenciaSilla(sillaNueva, Bus)
            if validador.getValidacion():
                for tiquetes in Tiquete.getTiquetesComprados():
                    if str(tiquetes.getPasajero().getCedula()) == numDocumento:
                        Bus.getSillaNoDisponibles().remove(str(tiquetes.getSillaTiquete()))
                        Bus.getSillaNoDisponibles().append(sillaNueva)
                        tiquetes.setSillaTiquete(sillaNueva)
                        messagebox.showinfo(title= "Cambio realizado con exito", message= tiquetes)
                        self.crearComprador()
                    for viajes in Viaje.getViajes():
                        for tiquetesTodos in viajes.tiquetesDisponibles():
                            if sillaNueva in tiquetesTodos.getSillaTiquete():
                                tiquetesTodos.setSillaTiquete(str(tiquetes.getSillaTiquete()))

        lbDocumento = ttk.Label(self.main, text = "Digite el numero del documento con el cualn\nse realizo la compra del tiquete")
        entryDocumento = ttk.Entry(self.main, textvariable= entryDocumentoVar)
        lbSillaNueva = ttk.Label(self.main, text = "Digite la nueva silla deseada")
        entrySillaNueva= ttk.Entry(self.main, textvariable= entrySillaNuevaVar)

        lbDocumento.pack()
        entryDocumento.pack()
        lbSillaNueva.pack()
        entrySillaNueva.pack()
        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()
    