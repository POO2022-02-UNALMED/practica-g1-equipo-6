import tkinter as tk
from tkinter import ttk
from PIL import Image, ImageTk
from ui_main.VentanaInicio.Descripcion import Descripcion
from ui_main.VentanaInicio.Salir import Salir
from ui_main.PaginaPrincipal import PaginaPrincipal
from ui_main.VentanaInicio.HojaVida import HojaVida
import os
import pathlib


class VentanaPrincipal(tk.Tk):
    def __init__(self):
        super().__init__()

        # Configuracion de la ventana
        self.wm_title("TransPOOrte")
        
        # Creacion de Frame principal
        container = ttk.Frame(self)
        container.pack(side="top", fill="both", expand=True)
        container.grid_rowconfigure(0, weight=1)
        container.grid_columnconfigure(0, weight=1)

        # Creacion de menu principal
        self.menubar = tk.Menu(self)
        self.config(menu=self.menubar)

        # Agregar comandos en el menu principal
        self.menuInicio =tk.Menu(self.menubar)
        self.menubar.add_cascade(
            label="Inicio", menu = self.menuInicio)
        
        self.menuInicio.add_command(label = "Descripcion", command= lambda: self.cambiarFrame(Descripcion))
        self.menuInicio.add_command(label = "Salir", command= lambda: self.cambiarFrame(Salir))

        self.frames = {}

        for F in (Descripcion, Salir):
            frame = F(master=self, contenedor=container)
            self.frames[F] = frame
            frame.grid(row=0, column=0, sticky="nsew")

        

        bntPAginaPrincipal = ttk.Button(self, text = "Ventana de usuario", command= self.abrir_ventana_principal)
        bntPAginaPrincipal.pack(side="bottom")

        
        self.hoja_vida = HojaVida(self)
        self.hoja_vida.pack(side="top")

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

    def abrir_ventana_principal(self):
        self.destroy()
        PaginaPrincipal()

    
