from gestor_aplicacion.clasesPrincipales.Viaje import Viaje


class Rentabilidad:
    global idViaje
    @classmethod
    def showMenuRentabilidad(cls):
        print(" ")
        print("----- RENTABILIDAD -----")
        print("[1] Visualizar Ocupacion de Viajes")
        print("[2] Rentabilidad De Viajes")

        opt = input("Ingrese una opcion: ")

        if opt == "1":
            Rentabilidad.visualizarOcupacion()
        if opt == "2":
            Rentabilidad.rentabilidad()


    @classmethod
    def visualizarOcupacion(cls):
        print("Visualizar ocupacion")
        for viaje in Viaje.getViajes():
                print("Viaje: "+ str(viaje.getId()) +"\r\n"+"Origen: "+viaje.getOrigen()+
        			"\r\n"+"Destino: "+viaje.getDestino())
            
        print("Ingrese el numero de viajes que deseas gestionar: ")
        idViaje = int(input())
        #viajeFinal = Viaje()

        for viaje in Viaje.getViajes():
            if viaje.getId() == idViaje:
                viajeFinal = viaje
        
        if viajeFinal.getEnViaje == False:
            print("VIAJE NO REGISTRADO")
            return
        tiquetesViaje =[]
        from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
        for tiquete in viajeFinal.getTiquetesTodos():
            if ((tiquete.getId() == idViaje) and (tiquete.getEstado() == False)):
                tiquetesViaje.append(tiquete)
        porcentaje =  ((((viajeFinal.getBus().getCapacidad()) - len(tiquetesViaje))*100))/viajeFinal.getBus().getCapacidad()
        Rentabilidad.evaluarPorcentajeOcupacion(viajeFinal, porcentaje)
    
    @classmethod
    def evaluarPorcentajeOcupacion(cls, viaje, porcentaje):
        if porcentaje >= 85:
            viaje.aumentarFrecuenta(1)
            print("El porcentaje de ocupacion del viaje fue de: "+ str(porcentaje)+"%")
            return viaje
        elif porcentaje >= 40 and porcentaje < 60:
            viaje.aumentarFrecuencia(2)
            print("El porcentaje de ocupacion del viaje fue de: "+ str(porcentaje)+"%")
            return viaje
        elif porcentaje >= 15 and porcentaje < 40:
            viaje.disminuirFrecuencia(3)
            print("El porcentaje de ocupacion del viaje fue de: "+ str(porcentaje)+"%")
            return viaje
        elif porcentaje < 15:
            print("1 Eliminar viaje")
            print("2 No eliminar")
            eliminar = int(input())
            if eliminar == 1:
                for tiqueteEliminar in Viaje.getTiquetesTodos:
                    if tiqueteEliminar.getEstado() and tiqueteEliminar.getId == idViaje:
                        print("Al siguiente tiquete hay que hacerle un reembolso: "+"\r\n"+tiqueteEliminar)
                viaje.eliminarViaje()
            
            else:
                print("Esperemos que no genere muchas Perdidas")
        return viaje

    
    @classmethod
    def rentabilidad(cls):
        print("Rentabilidad de viajes")
        for todosViaje in Viaje.getViajes():
            print(todosViaje)
        
        entrada = int(input("Digite el id del viaje al cual le quiere calcular la rentabilidad"))
        
        for todosViaje in Viaje.getViajes():
            if todosViaje.getId() == entrada:
                Rentabilidad.rentabilidadViaje(todosViaje, entrada)
            else:
                continue
    
    @classmethod
    def rentabilidadViaje(cls, viaje, entrada):
        valorTiquetes = 0
        sillasOcupadas = 0
        for tiqueteViaje in Viaje.getTiquetesTodos():
            if tiqueteViaje.getEstado() and tiqueteViaje.getId() == entrada:
                valorTiquetes += tiqueteViaje.getValor()
                sillasOcupadas += 1
            else:
                continue
        print(viaje)
        print("La ocupacion del vehiculo de este viaje fue del : " + str((100 / len(Viaje.getTiquetesTodos()) * sillasOcupadas)) + "%" + "," + 
	  " con " + str(viaje.getBus().getCapacidad()) + " sillas disponibles en total. \n")
        print("Para este viaje se genero por tiquetes $" + str(valorTiquetes) + " y su costo de operacion fue de " + str(viaje.getCostoViaje()) + 
			  " con una utilidad de " + str(valorTiquetes - viaje.getCostoViaje())+ "\n")
    
        ocupacionT = 0
        cantViajes = 0
        costoTot = 0
        gananciaT = 0

        for cadaViaje in Viaje.getViajes():
            if cadaViaje.getOrigen() == viaje.getOrigen() and cadaViaje.getDestino() == viaje.getDestino():
                valorTaux = 0
                ocupadasAux = 0
                for tiqueteAux in Viaje.getTiquetesTodos():
                    if tiqueteAux.getEstado() :
                        valorTaux += tiqueteAux.getValor()
                        ocupadasAux += 1
                    else:
                        continue
                
                ocupacionT += 100/len(Viaje.getTiquetesTodos()) * ocupadasAux
                cantViajes += 1
                costoTot += cadaViaje.getCostoViaje()
                gananciaT += valorTaux
                
            else:
                continue
        print("La ocupacion promedio para la ruta "+ viaje.getOrigen()+"-"+viaje.getDestino()+ " es del " + str(ocupacionT/cantViajes) + "%"+
				" y su utilidad promedio es de " + str(gananciaT - costoTot))