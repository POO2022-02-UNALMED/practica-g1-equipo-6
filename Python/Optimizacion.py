
import math

class Optimizacion:
    @staticmethod
    def showMenuOptimizacion():
        print(" ") #Menu funcionalidad optimizacion
        print("----- SISTEMA DE OPTIMIZACION -----")
        print("¿Que operación desea realizar?")
        print("[1] Optimizar precio:Obtener promoción")
        print("[2] Optimizar viajes: viajes con paradas")

        sc = input()
        ind = input()

        opcion = int(Optimizacion.sc.nextInt())
        if opcion == 1:
            Optimizacion.ObtenerPromocion()
        elif opcion == 2:
            Optimizacion.ViajesParadas()

    #el viaje que deseas comprar tiene pocos tiquetes, tenemos la opcion de promo
    @staticmethod
    def ObtenerPromocion():
        print("Ingrese su documento")
        numDocumento =Optimizacion.sc.nextInt()
        for tiquetes in Tiquete.getTiquetesComprados():
            if tiquetes.getPasajero().getCedula() == numDocumento:
                    capacidadcal =math.trunc((tiquetes.getViaje().getBus().getCapacidad()*90) / float(100)) #cambiar
                    if len(tiquetes.getViaje().tiquetesDisponibles())>=capacidadcal:
                        for viaje in Viaje.getViajes():
                            if viaje.getOrigen().casefold() == tiquetes.getViaje().getOrigen().casefold() and viaje.getDestino().casefold() == tiquetes.getViaje().getDestino().casefold() and len(viaje.tiquetesDisponibles()) != 0 and viaje.getEnViaje()==True and len(viaje.tiquetesDisponibles())<=len(tiquetes.getViaje().tiquetesDisponibles()):
                                HoraCliente =tiquetes.getViaje().getHora_inicio() #hora de inicio del tiquete
                                HoraViaje =viaje.getHora_inicio() #hora de inicio del viaje
                                partesCli = []
                                partesVia = [] 
                                partesCli = HoraCliente.split(":")
                                partesVia = HoraViaje.split(":")
                                hora_1 =int(partesCli[0]) #separar por hora/minuto y convertir a entero
                                min_1 =int(partesCli[1])
                                hora_2 =int(partesVia[0])
                                min_2 =int(partesVia[1])
                            if hora_2>=hora_1:
                                horasDcto = None
                                hora_2-=hora_1
                                min_2-=min_1
                                horasDcto=(hora_2*60+min_2)
                                if horasDcto>=60 and horasDcto<120:
                                    print(viaje.getPrecio()-(math.trunc((viaje.getPrecio()*20) / float(100))))
                                    print("id : ["+str(viaje.getId())+"] = " +viaje.toString()+"Precio con descuento"+(viaje.getPrecio()-(math.trunc((viaje.getPrecio()*20) / float(100)))))
                                    #viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*20)/100))
                                elif horasDcto>=120:
                                    print(viaje.getPrecio()-(math.trunc((viaje.getPrecio()*30) / float(100))))
                                    print("id : ["+str(viaje.getId())+"] = " +viaje.toString()+"Precio con descuento"+(viaje.getPrecio()-(math.trunc((viaje.getPrecio()*30) / float(100)))))
                                    #viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*30)/100))
                            else:
                                print("No tenemos una promocion para ti en este momento D':")
            else:
                print("No hay viajes disponibles con estas condicions, estamos trabajando en ello :D")





    #se puede usar el codigo para acceder a la instancia en vez del instanceof
    @staticmethod
    def ViajesParadas():
        print("Ingrese el origen")
        origen =Optimizacion.sc.next().toUpperCase()
        print("Ingrese el destino")
        destino =Optimizacion.sc.next().toUpperCase()
        promEjecutivo = 0 #variable para calcular el precio de bus Ejecutivo
        promEuro = 0 #variable para calcular el precio de bus EuroVan
        promTecno = 0 #variable para calcular el precio de bus TecnoVan
        iterador_1 = 0
        iterador_2 = 0
        iterador_3 = 0
        for viaje in Viaje.getViajes():
            if viaje.getOrigen().casefold() == origen.casefold() and len(viaje.tiquetesDisponibles()) != 0 and viaje.getEnViaje():
                if viaje.getDestino().casefold() == destino:
                    if isinstance(viaje.getBus(), Ejecutivo):
                        iterador_1+=1
                        promEjecutivo+=promEjecutivo #*es mejor solo asignar el precio y no hacer calculos intermedios *
                        print("id : ["+str(viaje.getId())+"] = " +viaje.toString())
                    elif isinstance(viaje.getBus(), EuroVans):
                        iterador_2+=1
                        promEuro+=promEuro
                        print("id : ["+str(viaje.getId())+"] = " +viaje.toString())
                    if isinstance(viaje.getBus(), TecnoVans):
                        iterador_3+=1
                        promTecno+=promTecno
                        print("id : ["+str(viaje.getId())+"] = " +viaje.toString())

                #aca hay error
                elif destino in viaje.getRuta().getParadas():
                    if iterador_1>0:
                        promEjecutivo=int((math.trunc(promEjecutivo / float(iterador_1))))
                        viaje.setPrecio(promEjecutivo)
                        print("id : ["+str(viaje.getId())+"] = " +viaje.toString())
                        iterador_1=0
                    elif iterador_2>0:
                        promEuro=int((math.trunc(promEuro / float(iterador_2))))
                        viaje.setPrecio(promEuro)
                        print("id : ["+str(viaje.getId())+"] = " +viaje.toString())
                        iterador_2=0
                    elif iterador_3>0:
                        promTecno=int((math.trunc(promTecno / float(iterador_3))))
                        viaje.setPrecio(promTecno)
                        print("id : ["+str(viaje.getId())+"] = " +viaje.toString())
                        iterador_3=0
                    else:
                        beta = None
                        beta=math.trunc(1 / float(len(viaje.getRuta().getParadas())+2))

//====================================================================================================
//End of the allowed output for the Free Edition of Java to Python Converter.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-java-to-python.html
//====================================================================================================
