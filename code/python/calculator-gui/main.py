#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from functools import partial
import tkinter as tk 

class calcku(tk.Tk):
    def __init__(self):
        tk.Tk.__init__(self)
        self.wm_title("Kalkulator sederhana")
        self.geometry("290x400")
        self.membuatButton()
    def membuatButton(self):
        self.layar=tk.Entry(self,width=40)
        self.layar.grid(row=0,column=0,padx=20,pady=10,columnspan=3)
        buttonList=[
        "1",'2','3','4','5','6','7','8','9','-','0','+','C','/','x','<=','='
        ]
        row=1
        column=0
        for text in buttonList:
            perintah=partial(self.tambah,text)
            self.layar.bind('<Return>',self.hai)
            if text == "x":
                perintah=partial(self.tambah,"*")
                tk.Button(self,text=text,height=3,width=2,padx=30,pady=2,command=perintah).grid(row=row,column=column)
            elif text == "=":
                tk.Button(self,text=text,width=24,pady=17,command=perintah).grid(row=row,column=column,columnspan=3,pady=10)
            else:
                tk.Button(self,text=text,height=3,width=2,padx=30,pady=2,command=perintah).grid(row=row,column=column)
            column+=1
            if column>2:
                column=0
                row+=1
    def tambah(self,key):
        if self.layar.get() == "Masukan Perintah Dengan Benar":
            self.layar.delete(0,tk.END)
        elif key=="C":
            self.layar.delete(0,tk.END)
        elif key == "<=":
            self.layar.delete(len(self.layar.get())-1,tk.END)
        elif key == "=":
            result=self.layar.get()
            print(result)
            if "=" in result:
                self.layar.delete(len(self.layar.get)-1,tk.END)
            if len(result) != 0:
                try:
                    result=eval(result)
                    self.layar.delete(0,tk.END)
                    self.layar.insert(tk.END,result)
                except:
                    self.layar.delete(0,tk.END)
                    self.layar.insert(tk.END,"Masukan Perintah Dengan Benar")
        else:
            self.layar.insert(tk.END,key)
    def hai(self,x):
        result=self.layar.get()
        print(result)
        if "=" in result:
                self.layar.delete(len(result)-1,tk.END)
        result=self.layar.get()
        self.layar.delete(0,tk.END)
        self.layar.insert(tk.END,eval(result))

if __name__ == "__main__":
    kalkulator= calcku()
    kalkulator.mainloop()