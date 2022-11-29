import datetime
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.clasesPrincipales.Servicio import Servicio


class comprarTiquete:
    @classmethod
    def viajesPorBus(cls):
        print("Ingrese una opcion de bus")
        print("1. Ejecutivo")
        print("2. Tecnovans")
        print("3. Eurovans")
        bus = input("Elija una opcion de bus")
        while (bus != "1") and (bus != "2") and (bus != "3"):
            print("Ingrese una opcion valida")
            bus = input("Elija una opcion de bus")
        if bus == "1":
            for viajes in Viaje.getViajes():
                if viajes.getBus().getCodigo() == 150:
                    # imprime los viajes que coinciden con la coondicion(Ejecutivo)
                    print(viajes)
        elif bus == "2":
            for viajes in Viaje.getViajes():
                if viajes.getBus().getCodigo() == 200:
                    print(viajes)
        elif bus == "3":
            for viajes in Viaje.getViajes():
                if viajes.getBus().getCodigo() == 250:
                    print(viajes)

    @classmethod
    def modificarSilla(cls):
        numDocumento = input("Digite su numero de documento")
        sillaVieja = input("Digite el numero de silla actual")
        sillaNueva = input("Digite su nueva silla")
        if sillaNueva == Bus.getSillaNoDisponibles():
            print("Silla ocupada")
        else:
            for tiquetes in Tiquete.getTiquetesComprados():
                if str(tiquetes.getPasajero().getCedula()) == numDocumento:
                    # Se le asigna la nueva silla al tiquete comprado
                    tiquetes.setSillaTiquete(sillaNueva)
                    # de la lista de sillasNo disponibles se remueve la silla inicial
                    Bus.getSillaNoDisponibles().remove(sillaVieja)
                    # de la lista de sillas no disponibles se agrega la nueva silla asignada
                    Bus.getSillaNoDisponibles().append(sillaNueva)
                    # imprime el tiquete con la nueva silla
                    print(tiquetes)
                for viajes in Viaje.getViajes():
                    for tiquetesTodos in viajes.tiquetesDisponibles():
                        if sillaNueva in tiquetesTodos.getSillaTiquete():
                            # se hace un intercambio: de la silla asignada anteriormente por la silla que habia comprado el usuario inicialmente
                            tiquetesTodos.setSillaTiquete(sillaVieja)

    @classmethod
    def adquirirServicio(cls):
        print("SERVICIOS")
        print(
            "Digite un servicio:\n MALETAS_EXTRA(5000),\n"
            + "		ALMOHADA(2500),\n"
            + "		AURICULARES(3000),\n"
            + "		VIAJAR_CON_MASCOTA(10000)"
        )
        servicio = input("Ingrese el servicio que desea adquirir: ")
        numDocumento = input("Ingrese su numero de documento: ")
        for tiquete in Tiquete.getTiquetesComprados():
            if str(tiquete.getPasajero().getCedula()) == numDocumento:
                valorServicio = Servicio[servicio].value
                tiquete.setValorServicio(valorServicio)
                print(tiquete)
            else:
                print("Tiquete no encontrado")

    @classmethod
    def comprarTiqueteTerminal(cls):
        # creo una instancia de pasajero
        compradorBase = Pasajero(
            "Juan", "Ardila", 1002819665, 21, "JuanArdila@gmail.com"
        )
        finalTiquete = Tiquete()  # creo unainstancia de tiqquete vacio
        print("Quieres buinput()ar un bus por: ")
        print("0. Origen")
        print("1. Destino")
        print("2. Origen y destino")
        print("3. Fecha ")
        opcionCompra = input()
        print("Los lugares disponibles de origen y destino son: ")
        for viaje in Viaje.getLugares():
            # Imprimir los lugares disponibles para viajar
            print(viaje)
        if opcionCompra == "0":
            print("Ingresa tu origen: ")
            opcionOrigen = input()
            if opcionOrigen not in Viaje.getLugares():
                print("Opcion de origen no disponible")
                return finalTiquete
            print("Tus opciones de viaje disponibles son: ")

            for viaje in Viaje.getViajes():
                if (
                    (viaje.getOrigen() == opcionOrigen)
                    & (len(viaje.tiquetesDisponibles()) != 0)
                    & viaje.getEnViaje()
                ):
                    print(f"id : [{viaje.getId()}] = [{str(viaje)}]")

            opcionViaje = input(
                "Ingrese una opcion de viaje: "
            )  # elige uno de los viajes
            for viaje in Viaje.getViajes():
                if (
                    (viaje.getOrigen() == opcionOrigen)
                    and (len(viaje.tiquetesDisponibles()) != 0)
                    and (str(viaje.getId()) == opcionViaje)
                ):
                    if opcionViaje == str(viaje.getId()):
                        print(viaje)
                        # elige uno de los tiquetes asociados al viaje elegido
                        tiquete = list(
                            filter(
                                lambda x: x.getId() == viaje.getId(),
                                viaje.tiquetesDisponibles(),
                            )
                        )[0]
                        # Se asigna el tiquete al comprador
                        Tiquete.asignarTiquete(compradorBase, tiquete)
                        # Sillas no disponibles
                        Bus.setSillaNoDisponibles(tiquete.getSillaTiquete())
                        print(tiquete)  # devuelve el tiquete
                        return tiquete
                    else:
                        # si la opcion ingresada no coincide con los viajes disponibles al origen einput()ogido
                        print("ID NO VALIDO")
                        return finalTiquete
        elif opcionCompra == "1":
            print("Ingresa tu destino: ")
            # lo mismo que el primero pero con destino
            opcionDestino = input()
            if opcionDestino not in Viaje.getLugares():
                print("Opcion de destino no disponible")
                return finalTiquete
            print("Tus opciones de viaje disponibles son: ")
            for viaje in Viaje.getViajes():
                if (
                    (viaje.getDestino() == opcionDestino)
                    & (len(viaje.tiquetesDisponibles()) != 0)
                    & viaje.getEnViaje()
                ):
                    print(f"id : [{viaje.getId()}] = [{str(viaje)}]")
            print("Ingrese una opcion de viaje: ")
            opcionViaje = input()
            for viaje in Viaje.getViajes():
                if (
                    (viaje.getDestino() == opcionDestino)
                    & (len(viaje.tiquetesDisponibles()) != 0)
                    & (str(viaje.getId()) == opcionViaje)
                ):
                    if opcionViaje == str(viaje.getId()):
                        tiquete = viaje.tiquetesDisponibles()[0]
                        Tiquete.asignarTiquete(compradorBase, tiquete)
                        print(tiquete)
                        return tiquete
                    else:
                        print("ID NO VALIDO")
                        return finalTiquete

        elif opcionCompra == "2":
            print("Ingresa tu origen: ")
            opcionOrigen = input()  # lo mismo pero con destino y origen
            print("Ingresa tu destino")
            opcionDestino = input()
            for viajes in Viaje.getViajes():
                if (viajes.getOrigen() == opcionOrigen) or (
                    viajes.getDestino() == opcionDestino
                ):
                    print("Viaje no disponible")
                return finalTiquete
            print("Tus opciones de viaje disponibles son: ")
            for viaje in Viaje.getViajes():
                if (
                    (viaje.getOrigen() == opcionOrigen)
                    & (viaje.getDestino() == opcionDestino)
                    & (len(viaje.tiquetesDisponibles()) != 0)
                    & viaje.getEnViaje()
                ):
                    print(f"id : [{viaje.getId()}] = [{str(viaje)}]")
            print("Ingrese una opcion de viaje: ")
            opcionViaje = input()
            for viaje in Viaje.getViajes():
                if (
                    (viaje.getOrigen() == opcionOrigen)
                    & (viaje.getDestino() == opcionDestino)
                    & (len(viaje.tiquetesDisponibles()) != 0)
                    & (str(viaje.getId()) == opcionViaje)
                ):
                    if opcionViaje == str(viaje.getId()):
                        tiquete = viaje.tiquetesDisponibles().get(0)
                        Tiquete.asignarTiquete(compradorBase, tiquete)
                        print(tiquete)
                        return tiquete
                    else:
                        print("ID NO VALIDO")
                        return finalTiquete
        elif opcionCompra == 3:
            localDate = input("Ingresa la fecha del viaje (aaaa-mm-dd) : ")
            # lo mismo pero con getfecha
            if localDate not in Viaje.getFechasViaje():
                print("Fecha no disponible")
                return finalTiquete
            print("Tus opciones de viaje disponibles son: ")
            for viaje in Viaje.getViajes():
                if (
                    viaje.getFecha()
                    is localDate
                    & (len(viaje.tiquetesDisponibles()) != 0)
                    & viaje.getEnViaje()
                ):
                    print(f"id : [{viaje.getId()}] = [{str(viaje)}]")
            print("Ingrese una opcion de viaje: ")
            opcionViaje = input()
            for viaje in Viaje.getViajes():
                if (
                    (viaje.getFecha() is localDate)
                    & (len(viaje.tiquetesDisponibles()) != 0)
                    & (str(viaje.getId()) == opcionViaje)
                ):
                    if opcionViaje == str(viaje.getId()):
                        tiquete = viaje.tiquetesDisponibles()[0]
                        Tiquete.asignarTiquete(compradorBase, tiquete)
                        print(tiquete)
                        return tiquete
                    else:
                        print("ID NO VALIDO")
                        return finalTiquete

        print("NO HAY TIQUETES DISPONIBLES PARA EL VIAJE QUE DESEAS")
        return finalTiquete
