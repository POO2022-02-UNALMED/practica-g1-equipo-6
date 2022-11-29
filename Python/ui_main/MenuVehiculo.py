import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from gestor_aplicacion.clasesPrincipales.Conductor import Conductor
from gestor_aplicacion.manejoErrores.Validador import Validador
from gestor_aplicacion.clasesHerencia.Ejecutivo import Ejecutivo
from gestor_aplicacion.clasesHerencia.EuroVans import EuroVans
from gestor_aplicacion.clasesHerencia.TecnoVans import TecnoVans
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
            self.sidebar, text="Eliminar vehiculo", command=self.eliminarVehiculo)
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
            tipoVehiculo = escogerVehiculoVar.get()
            placaVehiculo = entryPlacaVar.get()
            nombreConductor = entryNombreVar.get()
            cedulaConductor = entryCedulaVar.get()
            celularConductor = entryCelularVar.get()
            salarioConductor = entrySalarioVar.get()

            validador = Validador()
            validador.validarCampoVacio(tipoVehiculo, placaVehiculo, nombreConductor, cedulaConductor,celularConductor,salarioConductor)
            if (validador.getValidacion()):
                validador.validarCampoNumerico(cedulaConductor)

            if validador.getValidacion():
                conductor = Conductor(nombreConductor, cedulaConductor, celularConductor, salarioConductor)

                if tipoVehiculo == "Ejecutivo":
                    Ejecutivo(placaVehiculo,conductor,[])
                    messagebox.showinfo(message="Vehiculo creado", title="Estado")

                elif tipoVehiculo == "TecnoVans":
                    TecnoVans(placaVehiculo,conductor,[])
                    messagebox.showinfo(message="Vehiculo creado", title="Estado")

                elif tipoVehiculo == "EuroVans":
                    EuroVans(placaVehiculo,conductor,[])
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
        ttk.Radiobutton(self.main, text = textEVehiculo, value = busENombre, variable= escogerVehiculoVar).pack()

        busEuNombre = EuroVans.__name__
        busEuCapacidad =  16
        textEuVehiculo = ("Vehiculo: "+busEuNombre+"\nCapacidad: "+ str(busEuCapacidad))
        ttk.Radiobutton(self.main, text = textEuVehiculo, value = busEuNombre, variable= escogerVehiculoVar).pack()

        busTNombre = TecnoVans.__name__
        busTCapacidad =  20
        textTVehiculo = ("Vehiculo: "+busTNombre+"\nCapacidad: "+str(busTCapacidad))
        ttk.Radiobutton(self.main, text = textTVehiculo, value = busTNombre, variable= escogerVehiculoVar).pack()
        
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
                    format('Origen','Destino','Fecha','Precio'), justify= "center").pack(pady = (0,15))
        for buses in Ejecutivo.getBuses():
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
        for buses in TecnoVans.getBuses():
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

    def eliminarVehiculo(self):
        self.master.limpiarFrame(self.main)

        lblMensajeInicio = ttk.Label(self.main, text="Buses", font=("Segoe UI", 20))
        lblEjecutivo = ttk.Label(self.main, text = "Tipo de vehiculo ha eliminar", anchor= "center")

        escogerVehiculoVar = tk.StringVar()
        entryPlacaVar = tk.StringVar()

        def submit():
            tipoVehiculo = escogerVehiculoVar.get()
            placaVehiculo = entryPlacaVar.get()

            validador = Validador()
            validador.validarCampoVacio(tipoVehiculo, placaVehiculo)

            if validador.getValidacion():
                for buses in Bus.getBuses():
                    if buses.getPlaca() == placaVehiculo:
                        Bus.getBuses().remove(buses) 
                messagebox.showinfo(message="Vehiculo eliminado", title="Estado")

        lblPlaca = ttk.Label(self.main, text="Placa del vehiculo")
        entryPlaca = ttk.Entry(self.main, textvariable=entryPlacaVar)

        lblMensajeInicio.pack()
        lblEjecutivo.pack()
      

        busENombre = Ejecutivo.__name__
        textEVehiculo = ("Vehiculo: "+busENombre)
        ttk.Radiobutton(self.main, text = textEVehiculo, value = busENombre, variable= escogerVehiculoVar).pack()

        busEuNombre = EuroVans.__name__
        textEuVehiculo = ("Vehiculo: "+busEuNombre)
        ttk.Radiobutton(self.main, text = textEuVehiculo, value = busEuNombre, variable= escogerVehiculoVar).pack()

        busTNombre = TecnoVans.__name__
        textTVehiculo = ("Vehiculo: "+busTNombre)
        ttk.Radiobutton(self.main, text = textTVehiculo, value = busTNombre, variable= escogerVehiculoVar).pack()
        
        lblPlaca.pack() 
        entryPlaca.pack()   

        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()

    def listaConductores(self):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
                    format('Nombre','Cedula','Celular','Salario'), justify= "center").pack(pady = (0,15))
        for conductores in Conductor.getConductores():
            ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:}".
            format(str(conductores._nombre), str(conductores._cedula), str(conductores._celular), str(conductores._sueldo))).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.modificarConductor()).pack()


    def modificarConductor(self):
        self.master.limpiarFrame(self.main)

        entryDocumentoVar = tk.StringVar()
        entryNombreVar = tk.StringVar()
        entryCedulaVar = tk.StringVar()
        entryCelularVar = tk.StringVar()
        entrySalarioVar = tk.StringVar()

        def submit():
            numDocumento = entryDocumentoVar.get()
            nombreConductor = entryNombreVar.get()
            cedulaConductor = entryCedulaVar.get()
            celularConductor = entryCelularVar.get()
            salarioConductor = entrySalarioVar.get()
            
            validador = Validador()

            validador.validarCampoVacio(numDocumento, nombreConductor,cedulaConductor,celularConductor,salarioConductor)
            if validador.getValidacion():
                validador.validarCampoNumerico(numDocumento)
            if validador.getValidacion():
                for conductor in Conductor.getConductores():
                    if str(conductor.getCedula()) == str(numDocumento):
                        conductor._nombre  = nombreConductor
                        conductor._cedula  = cedulaConductor
                        conductor._celular  = celularConductor
                        conductor._sueldo  = salarioConductor
                        messagebox.showinfo(message="Conductor Cambiado", title="Estado")

        lbDocumento = ttk.Label(self.main, text = "Digite el numero del documento del\nconductor que se remplaza")
        entryDocumento = ttk.Entry(self.main, textvariable= entryDocumentoVar)
        lbConductorNuevo = ttk.Label(self.main, text = "Digite los datos de el nuevo conductor \n")
        lblNombre = ttk.Label(self.main, text="Nombre del conductor")
        entryNombre = ttk.Entry(self.main, textvariable=entryNombreVar)
        lblCedula = ttk.Label(self.main, text="Cedula del conductor")
        entryCedula = ttk.Entry(self.main, textvariable=entryCedulaVar)
        lblCelular = ttk.Label(self.main, text="Celular del conductor")
        entryCelular = ttk.Entry(self.main, textvariable=entryCelularVar)
        lblSalario= ttk.Label(self.main, text="Salario del conductor")
        entrySalario = ttk.Entry(self.main, textvariable=entrySalarioVar)

        lbDocumento.pack()
        entryDocumento.pack()
        btnVolver = ttk.Button(self.main, text = "Consultar", command= lambda: self.listaConductores()).pack()
        lbConductorNuevo.pack()
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

        



