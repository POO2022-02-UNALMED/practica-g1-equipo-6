import tkinter as tk
from tkinter import ttk
from PIL import Image, ImageTk
from funcionalidades.compraTiquete import comprarTiquete
from ui_main.PaginaPrincipal import PaginaPrincipal
from ui_main.MenuTiquete import MenuTiquete
import os
import pathlib


class VentanaPrincipal(tk.Tk):
    def __init__(self):
        super().__init__()

        # Configuracion de la ventana
        self.wm_title("TransPOOrte")
        self.geometry("500x450")
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
        self.menubar.add_command(
            label="Inicio", command=lambda: self.cambiarFrame(PaginaPrincipal))
        self.menubar.add_command(label="Viaje")
        self.menubar.add_command(label="Vehiculo")
        self.menubar.add_command(
            label="Tiquete", command=lambda: self.cambiarFrame(MenuTiquete))
        self.menubar.add_command(label="Rentabilidad")
        self.menubar.add_command(label="Optimizacion")

        self.frames = {}

        for F in (PaginaPrincipal, MenuTiquete):
            frame = F(master=self, contenedor=container)
            self.frames[F] = frame
            frame.grid(row=0, column=0, sticky="nsew")

        # Poner pagina principal al iniciar la app
        self.cambiarFrame(PaginaPrincipal)

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

