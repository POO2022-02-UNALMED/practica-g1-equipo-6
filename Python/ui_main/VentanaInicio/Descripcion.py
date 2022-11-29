import tkinter as tk
from tkinter import ttk

class Descripcion(tk.Frame):
    def __init__(self, master, contenedor):
        tk.Frame.__init__(self, contenedor)

        self.master = master

        self.main = ttk.Frame(self, borderwidth="2")
        self.main.pack(side="right", fill="both", expand=True)

        textDescripcion = """Estimado usuario, bienvenido a TransPOOrte. 
Somos una APP que gestiona los diferentes servicios de una flota 
de autobuses con diferentes funcionalidades como:  automatizar la 
compra de tiquetes, la ocupación y disponibilidad de viajes, 
modificacion en los viajes, buses y conductores que permiten la creacion 
de estos mismos. Todo esto, con el objetivo de 
facilitar y mejorar la calidad del tedioso proceso de organizar un viaje."""
        lblDescripcion = ttk.Label(self.main, text = textDescripcion, justify=tk.CENTER ).pack()