from ui_main.MenuRentabilidad import MenuRentabilidad
from ui_main.VentanaPrincipal import VentanaPrincipal
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.clasesPrincipales.Conductor import Conductor
from gestor_aplicacion.clasesPrincipales.Ruta import Ruta
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesHerencia.Ejecutivo import Ejecutivo
from gestor_aplicacion.clasesHerencia.EuroVans import EuroVans
from gestor_aplicacion.clasesHerencia.TecnoVans import TecnoVans
from gestor_aplicacion.clasesPrincipales.Servicio import Servicio
from datetime import datetime
from datetime import timedelta


def main():
    u1 = Pasajero("Andres","Lema",1039458020,30, "example@email.com")
    u2 = Pasajero("Daniel","Estrada",1020486909,24, "example2@email.com")
    u3 = Pasajero("Nicolas","Perez",1036214594,21, "example3@email.com")
    u4 = Pasajero("Valen","Ardila",102819668,19, "example4@email.com")
    u5 = Pasajero("Camilo","Bello",1004354028,20, "example5@email.com")

        #//FECHAS PRUEBAS

    fin = (datetime.now() + timedelta(days=15))
    inicio = (datetime.now() + timedelta(days=2))
    intermedio = (datetime.now() + timedelta(days=10))

    #//PARADAS
    paradas_1 = []
    paradas_1.append("Medellin")
    paradas_1.append("Manizales")
    paradas_1.append("Popayan")
    paradas_2 = []
    paradas_3 = []
    paradas_4 = []
    paradas_5 = []

    #//RUTAS

    uno = Ruta("MONTERIA", "PASTO", 120,paradas_1)
    dos = Ruta("MEDELLIN", "MANIZALES",100,paradas_2)
    tres = Ruta("POPAYAN", "CALI",80,paradas_3)
    cuatro = Ruta("MEDELLIN", "CARTAGENA",150,paradas_4)
    cinco = Ruta("PASTO", "MONTERIA",120,paradas_5)
    seis = Ruta("MANIZALES", "MEDELLIN",100,paradas_1)
    siete = Ruta("CALI","POPAYAN",80,paradas_2)
    ocho = Ruta("CALI", "CARTAGENA",170,paradas_3)
    nueve = Ruta("CARTAGENA", "MEDELLIN",150,paradas_4)
    diez = Ruta("CARTAGENA","CALI",170,paradas_5)

    #/SILLAS
    sillasv1 = []
    sillasv1.append("A1")
    sillasv1.append("A2")
    sillasv1.append("A3")
    sillasv1.append("A4")
    sillasv2 = []
    sillasv2.append("B1")
    sillasv2.append("B2")
    sillasv2.append("B3")
    sillasv2.append("B4")
    sillasv2.append("B5")
    sillasv2.append("B6")
    sillasv2.append("B7")
    sillasv2.append("B8")
    sillasv3 = []
    sillasv3.append("C1")
    sillasv3.append("C2")
    sillasv3.append("C3")
    sillasv3.append("C4")
    sillasv3.append("C5")
    sillasv3.append("C6")
    sillasv3.append("C7")
    sillasv3.append("C8")

    #//CONDUCTORES
    cond1 = Conductor("Don Javier",1021123854,3004569696, 4000)
    cond2 = Conductor("Don Hernan",1021123855,3007569696, 4100)
    cond3 = Conductor("Dona Marta",1021123856,3004589696, 4200)

    #////BUS
    B1 = Ejecutivo("AAA000",cond1,sillasv1)
    B2 = EuroVans("ZZZ999",cond2,sillasv1)
    B3 = TecnoVans("ABC123",cond3, sillasv1)

    #VIAJES
    viaje2 = Viaje(1,40000,"8:00","12:00",uno,intermedio,B1, True,7)
    viaje3 = Viaje(2,40000,"8:00","11:00",uno,fin, B2, True,7)
    viaje1 = Viaje(3,40000,"8:00","13:00",tres,intermedio, B3, True,7)
    viaje4 = Viaje(4,40000,"8:00","20:00",cuatro, fin,B1, True, 7)
    viaje5 = Viaje(5,40000,"8:00","14:00",cinco,intermedio, B2, True, 7)
    viaje6 = Viaje(6,40000,"8:00","15:00",seis,intermedio,B3, True,7)
    viaje7 = Viaje(7,40000,"8:00","16:00",siete, intermedio, B1, True,7)
    viaje9 = Viaje(8,40000,"8:00","16:00", ocho, intermedio,B2, True,7)
    viaje10 = Viaje(9,40000,"8:00","16:00", nueve, intermedio,B3, True,7)
    viaje8 = Viaje(10,40000,"8:00","17:00",diez,intermedio, B2,True,7)
    viaje11 = Viaje(9,40000,"9:10","17:00", nueve,intermedio,B3, True,7)
    
    mainWindow = VentanaPrincipal()
    mainWindow.mainloop()


if __name__ == '__main__':
    main()
''