from gestorAplicacion.clasesHerencia import EuroVans
from gestorAplicacion.clasesPrincipales import *

class AdministrarViaje:

    @staticmethod
    def showMenuViaje():
        print(" ")
        print("----- SISTEMA DE ADMINISTRACION DE VIAJES -----")

        print("¿Que operación desea realizar?")
        print("[1] Agregar un nuevo viaje")
        print("[2] Modificar un viaje")
        print("[2] Cancelar un viaje")
        opcion = uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
        if opcion == 1:
            AdministrarViaje.agregarViaje()
        elif opcion == 2:
            AdministrarViaje.modificarViaje()
        elif opcion == 3:
            AdministrarViaje.cancelarViaje()


    @staticmethod
    def agregarViaje():
        #public Viaje(String hora_inicio, String hora_llegada,Ruta ruta,Bus bus, int frecuencia, int costoViaje) 
        print("Digite id del viaje")
        id =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
        print("Digite la hora de inicio del viaje (HH:MM)")
        hora_inicio =uiMain.funcionalidades.AdministrarViaje.sc.next()
        print("Digite la hora de llegada al destino del viaje (HH:MM)")
        hora_llegada =uiMain.funcionalidades.AdministrarViaje.sc.next()
        print("Seleccione una de las siguientes rutas")
        print("En caso de que no se encuentre la ruta necesitada, ingrese -1, para ingresar una nueva")
        Ruta.listadoRutas() #imprime las rutas
        rutaSeleccionada =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
        ruta = None
        if rutaSeleccionada==-1:
            #Ruta(String origen, String destino, int km, ArrayList<String> paradas)
            print("Digite el origen de la ruta")
            origen =uiMain.funcionalidades.AdministrarViaje.sc.next()
            print("Digite el destino de la ruta")
            destino =uiMain.funcionalidades.AdministrarViaje.sc.next()
            print("Digite el numero de km de la ruta")
            km =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
            print("Ingrese las paradas (separadas por un espacio)")
            print("Si no desea escribir mas paradas, escriba NO")
            parada = None
            paradas = []
            while True:
                parada=uiMain.funcionalidades.AdministrarViaje.sc.next()
                if parada.upper() == "NO":
                    break
                else:
                    paradas.append(parada)
            ruta=Ruta.crearRuta(origen, destino, km, paradas)
        else:
            ruta=Ruta.getRutas().get(rutaSeleccionada)
        cond2 = Conductor("Don Hernan",1021123855,3007569696, 4100)
        sillasv2 = []
        sillasv2.append("B1")
        sillasv2.append("B2")
        sillasv2.append("B3")
        sillasv2.append("B4")
        sillasv2.append("B5")
        sillasv2.append("B6")
        sillasv2.append("B7")
        sillasv2.append("B8")
        bus = gestorAplicacion.clasesHerencia.EuroVans("Ztr999",cond2,sillasv2)


        print("Digite la frecuencia del viaje")
        frecuencia =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
        print("Digite el costo del viaje")
        costoViaje =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
        Empresa.crearViaje(id, hora_inicio, hora_llegada, ruta, bus, frecuencia, costoViaje)

    @staticmethod
    def modificarViaje():
        print("Seleccione uno de los siguientes viajes")
        Viaje.listadoViajes() #imprime los viajes
        viajeSeleccionado =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
        Viaje.getViajes().get(viajeSeleccionado)
        while True:
            print("¿Que le desea modificar al viaje?")
            print("[1] Fecha")
            print("[2] Precio")
            opcion = uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
            if opcion == 1:
                print("Digite la nueva fecha del viaje (YYYY-MM-DD)")
                fechaNueva =java.time.LocalDate.parse(uiMain.funcionalidades.AdministrarViaje.sc.next())
                Viaje.getViajes().get(viajeSeleccionado).setFecha(fechaNueva)
            elif opcion == 2:
                print("Digite el nuevo precio del viaje")
                precioViaje =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
                Viaje.getViajes().get(viajeSeleccionado).setPrecio(precioViaje)
            Viaje.getViajes().get(viajeSeleccionado)

            print("¿Desea modificar algo mas (Si-No)?")
            if uiMain.funcionalidades.AdministrarViaje.sc.next().toUpperCase() == "NO":
                break




    @staticmethod
    def cancelarViaje():
        print("Seleccione uno de los siguientes viajes")
        Viaje.listadoViajes() #imprime los viajes
        viajeSeleccionado =uiMain.funcionalidades.AdministrarViaje.sc.nextInt()
        Viaje.getViajes().get(viajeSeleccionado).eliminarViaje()


