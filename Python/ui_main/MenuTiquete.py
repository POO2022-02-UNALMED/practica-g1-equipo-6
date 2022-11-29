import tkinter as tk
from tkinter import ttk
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.manejoErrores.Validador import Validador
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Servicio import Servicio
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from tkinter import messagebox


class MenuTiquete(tk.Frame):
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
        self.crearComprador()

    def crearSideBar(self):
        lblImage = ttk.Label(self.sidebar, image=self.logo)
        lblBrand = ttk.Label(
            self.sidebar, text="TransPOOrte", font=("Segoe UI", 15))
        btnComprarTiquete = ttk.Button(
            self.sidebar, text="Comprar Tiquete", command=self.crearComprador)
        btnAdquirirServicio = ttk.Button(
            self.sidebar, text="Adquirir Servicio", command=self.adquirServicio)
        btnViajePorBus = ttk.Button(
            self.sidebar, text="Viaje por Bus", command=self.viajePorBus)
        btnModificarSilla = ttk.Button(
            self.sidebar, text= "Modificar silla", command = self.modificarSilla)

        # Pack widgets
        lblImage.pack()
        lblBrand.pack(padx="5", pady=(0, 25))
        btnComprarTiquete.pack(fill="x", padx="5", pady="3")
        btnAdquirirServicio.pack(fill="x", padx="5", pady="3")
        btnViajePorBus.pack(fill="x", padx="5", pady="3")
        btnModificarSilla.pack(fill= "x", padx= "5", pady= "3")

    
    def mostrarViajes(self, viajes, pasajero):
        self.master.limpiarFrame(self.main)
        lblTitulo = ttk.Label(self.main, text = "Viajes disponibles").pack(pady = (0,30))
        rbdViajeVar = tk.StringVar()

        def submit():
            viajeVar = rbdViajeVar.get()
            validador = Validador()
            validador.validarCampoVacio(viajeVar)

            if validador.getValidacion():
                tiqueteFinal = None
                for viaje in viajes: 
                    for tiquete in viaje.tiquetesDisponibles():
                        if  tiquete.getId() == int(viajeVar):
                            tiqueteFinal = tiquete 
                            break
                Tiquete.asignarTiquete(pasajero, tiqueteFinal)
                Bus.setSillaNoDisponibles(tiqueteFinal.getSillaTiquete())
                messagebox.showinfo(title= "Tiquete realizado con exito", message= tiqueteFinal)
                self.crearComprador()

        for viaje in viajes: 
            ttk.Radiobutton(self.main, text = viaje, value = viaje.getId(), variable= rbdViajeVar).pack()

        btnViaje = ttk.Button(self.main, text = "Submit", command = submit )
        btnViaje.pack()
        
    def comprarTiquete(self, pasajero):
        self.master.limpiarFrame(self.main)
        lblMensajeInicio = ttk.Label(self.main, text="Comprar tiquete", font=("Segoe UI", 20))
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
                self.mostrarViajes(viajesFiltrados, pasajero)
        
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


    def crearComprador(self):
        self.master.limpiarFrame(self.main)
        
        entryNombreVar = tk.StringVar()
        entryApellidoVar = tk.StringVar()
        entryCedulaVar = tk.StringVar()
        entryCorreoVar = tk.StringVar()

        def submit():
            nombrePasajero = entryNombreVar.get()
            apellidoPasajero = entryApellidoVar.get()
            cedulaPasajero = entryCedulaVar.get()
            correoPasajero = entryCorreoVar.get()
            validador = Validador()
            validador.validarCampoVacio(nombrePasajero, apellidoPasajero, cedulaPasajero, correoPasajero)
            if (validador.getValidacion()):
                validador.validarCampoNumerico(cedulaPasajero)

            if validador.getValidacion():
                pasajero = Pasajero(nombrePasajero, apellidoPasajero, cedulaPasajero, 18, correoPasajero)
                self.comprarTiquete(pasajero)


        lblTitulo = ttk.Label(self.main, text="Formulario de registro", font=("Segoe UI", 20))
        lblNombre = ttk.Label(self.main, text="Nombres del pasajero")
        entryNombre = ttk.Entry(self.main, textvariable=entryNombreVar)
        lblApellido = ttk.Label(self.main, text="Apellidos del pasajero")
        entryApellido = ttk.Entry(self.main, textvariable=entryApellidoVar)
        lblCedula = ttk.Label(self.main, text="Cedula del pasajero")
        entryCedula = ttk.Entry(self.main, textvariable=entryCedulaVar)
        lblCorreo = ttk.Label(self.main, text="Correo del pasajero")
        entryCorreo = ttk.Entry(self.main, textvariable=entryCorreoVar)
        
        lblTitulo.pack(pady=(0, 20))
        lblNombre.pack()
        entryNombre.pack()
        lblApellido.pack()
        entryApellido.pack()
        lblCedula.pack()
        entryCedula.pack()
        lblCorreo.pack()
        entryCorreo.pack()        

        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()


    def adquirServicio(self):
        self.master.limpiarFrame(self.main)

        numDocumentoVar = tk.StringVar()
        escogerServicioVar = tk.StringVar()

        def submit():
            numDocumento = numDocumentoVar.get()
            escogerServicio = escogerServicioVar.get()
            validador = Validador()
            
            validador.validarCampoVacio(numDocumento, escogerServicio)
            if validador.getValidacion():
                validador.validarCampoNumerico(numDocumento)
            validador.validarDocumento(numDocumento, Tiquete)
            
            
            if validador.getValidacion():
                for tiquete in Tiquete.getTiquetesComprados():
                    if str(tiquete.getPasajero().getCedula()) == numDocumento:
                        tiquete.setValorServicio(int(escogerServicio))
                        messagebox.showinfo(title= "Compra realizada con exito", message= tiquete)
                        self.crearComprador()



        lblMensajeInicio = ttk.Label(self.main, text="Adquirir Servicio", font=("Segoe UI", 20))
        lblDocumento = ttk.Label(self.main, text = "Ingrese el numéro de documento con el cual realizo la\ncompra del tiquete")
        entryDocumento = ttk.Entry(self.main, textvariable= numDocumentoVar )
        lblEscogerServicio = ttk.Label(self.main, text= "Escoja el servicio que desea adquirir")

        lblMensajeInicio.pack()
        lblDocumento.pack()
        entryDocumento.pack()
        lblEscogerServicio.pack()
        for servicio in (Servicio): 
            servicioNombre = servicio.name.split("_") 
            textServicio = ("Servicio: "+servicioNombre[0]+"\nValor: "+ str(servicio.value))
            ttk.Radiobutton(self.main, text = textServicio, value = servicio.value, variable= escogerServicioVar).pack()
        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()

    def volverViajeBus(self):
        self.master.limpiarFrame(self.main)
        self.viajePorBus()

    def ejecutivo(self):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
                    format('Origen','Destino','Fecha','Precio'), justify= "center").pack(pady = (0,15))
        for viajes in Viaje.getViajes():
            if viajes.getBus().getCodigo() == 150:
                # imprime los viajes que coinciden con la coondicion(Ejecutivo)
                fecha = str(viajes.getFecha()).split(" ")
                ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
                    format(viajes.getOrigen(), viajes.getDestino(), fecha[0], viajes.getPrecio())).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.volverViajeBus()).pack()

    def euroVans(self):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
                    format('Origen','Destino','Fecha','Precio'), justify= "center").pack(pady = (0,15))
        for viajes in Viaje.getViajes():
            if viajes.getBus().getCodigo() == 250:
                # imprime los viajes que coinciden con la coondicion(Ejecutivo)
                fecha = str(viajes.getFecha()).split(" ")
                ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
                    format(viajes.getOrigen(), viajes.getDestino(), fecha[0], viajes.getPrecio())).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.volverViajeBus()).pack()

    def tecnoVans(self):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
                    format('Origen','Destino','Fecha','Precio'), justify= "center").pack(pady = (0,15))
        for viajes in Viaje.getViajes():
            if viajes.getBus().getCodigo() == 200:
                # imprime los viajes que coinciden con la coondicion(Ejecutivo)
                fecha = str(viajes.getFecha()).split(" ")
                ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
                    format(viajes.getOrigen(), viajes.getDestino(), fecha[0], viajes.getPrecio())).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.volverViajeBus()).pack()

    def viajePorBus(self):
        self.master.limpiarFrame(self.main)
        lblMensajeInicio = ttk.Label(self.main, text="Viaje por bus", font=("Segoe UI", 20))
        lblEjecutivo = ttk.Label(self.main, text = "Ejecutivo es un un servicio con recorridos cortos que le ofrece\nal ususario "
            +"viajes rapidos y seguros, cuenta con 24 sillas,\nWifi, Baño, tomaccorientes y aire acondicionado. ", anchor= "center")
        lblEuroVans = ttk.Label(self.main, text = "EuroVans es un vehiculo diseñado para recorridos intermedios,\nconfortables con , "
            +"un sistema de entretenimiento\nambiental adecuado para que su viaje tenga los mejores estrenos\nde cine a bordo, "
            +"cuenta con 16 sillas, Wifi, Baño,\ntomaccorientes y aire acondicionado. ", anchor= "center")
        lblTecnoVans = ttk.Label(self.main, text = "TecnoVans es un servicio con recorridos de distancia media,\n"
            +"viaja directo a donde quieras ir con todos los servicios\nque necesitas para sentirte seguro y comodo,"
            +"cuenta con 20 sillas,\nWifi, Baño, tomaccorientes y aire acondicionado. ", anchor= "center")
        btnEjecutivo = ttk.Button(self.main, text = "Ejecutivo", command= lambda: self.ejecutivo())
        btnEuroVans = ttk.Button(self.main, text = "EuroVans", command= lambda: self.euroVans())
        btnTecnovans = ttk.Button(self.main, text = "TecnoVans", command= lambda: self.tecnoVans())
        
        lblMensajeInicio.pack()
        lblEjecutivo.pack()
        btnEjecutivo.pack()
        lblEuroVans.pack()
        btnEuroVans.pack()
        lblTecnoVans.pack()
        btnTecnovans.pack()

    def modificarSilla(self):
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
    