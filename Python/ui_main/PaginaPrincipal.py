import tkinter as tk
from tkinter import ttk


class PaginaPrincipal(tk.Frame):
    def __init__(self, master, contenedor):
        tk.Frame.__init__(self, contenedor)

        label = tk.Label(self, text="Home Page", font=('Times', '20'))
        label.pack(pady=0, padx=0)
