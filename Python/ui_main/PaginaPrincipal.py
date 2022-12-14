import tkinter as tk
from tkinter import ttk
from ui_main.MenuTiquete import MenuTiquete
from ui_main.MenuRentabilidad import MenuRentabilidad
from ui_main.MenuViaje import MenuViaje
from ui_main.MenuVehiculo import MenuVehiculo
from ui_main.Inicio import Inicio
from ui_main.MenuOptimizacion import MenuOptimizacion
from PIL import Image, ImageTk
import os
import pathlib




class PaginaPrincipal(tk.Tk):
    def __init__(self):
        super().__init__()

        self.wm_title("TransPOOrte")
        self.geometry("700x500")
        self.resizable(False, False)

        # Creacion de Frame principal
        container = ttk.Frame(self)
        container.pack(side="top", fill="both", expand=True)
        container.grid_rowconfigure(0, weight=1)
        container.grid_columnconfigure(0, weight=1)

        # Creacion de menu principal
        self.menubar = tk.Menu(self)
        self.config(menu=self.menubar)

        # Agregar comandos en el menu principal
        self.menubar.add_command(label="Inicio", command=lambda: self.cambiarFrame(Inicio))
        self.menubar.add_command(label="Viaje", command=lambda: self.cambiarFrame(MenuViaje))
        self.menubar.add_command(label="Vehiculo", command=lambda: self.cambiarFrame(MenuVehiculo))
        self.menubar.add_command(label="Tiquete", command=lambda: self.cambiarFrame(MenuTiquete))
        self.menubar.add_command(label="Rentabilidad", command=lambda: self.cambiarFrame(MenuRentabilidad) )
        self.menubar.add_command(label="Optimizacion", command=lambda: self.cambiarFrame(MenuOptimizacion))
        self.frames = {}

        for F in (Inicio, MenuTiquete, MenuVehiculo, MenuViaje, MenuRentabilidad,MenuOptimizacion):
            frame = F(master=self, contenedor=container)
            self.frames[F] = frame
            frame.grid(row=0, column=0, sticky="nsew")

        # Poner pagina Inicio al iniciar la app
        self.cambiarFrame(Inicio)

    def cambiarFrame(self, claseFrame):
        frame = self.frames[claseFrame]
        frame.tkraise()

    @staticmethod
    def cargarImagen(rutaImagen):
        path = os.path.join(pathlib.Path(__file__).parent.parent.absolute())
        RUTA_ASSETS = path+ "/assets/imagenes/"
        image = Image.open(RUTA_ASSETS + rutaImagen + ".png").resize((80, 70))
        return ImageTk.PhotoImage(image)

        
    @staticmethod
    def limpiarFrame(frame):
        for widget in frame.winfo_children():
            widget.destroy()


    def volverVentanaPrincipal():
        from ui_main.VentanaInicio.VentanaPrincipal import VentanaPrincipal
        VentanaPrincipal()




