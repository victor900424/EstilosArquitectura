class Filtro:
    def procesar(self, datos):
        raise NotImplementedError("Subclase debe implementar el método procesar")

class ExtraerDatos(Filtro):
    def __init__(self, fuente):
        self.fuente = fuente
    
    def procesar(self, datos=None):
        # Se simula la extracción de los datos
        print(f"Extrayendo datos del origen de informacion: {self.fuente}")
        datos = [1, 2, 3, 4, 5]
        return datos

class TransformarDatos(Filtro):
    def procesar(self, datos):
        # Generamos una transformacion sencilla de los datos
        print("Transformando los datos")
        datos_transformados = [x * 2 for x in datos]
        return datos_transformados

class CargarDatos(Filtro):
    def __init__(self, destino):
        self.destino = destino
    
    def procesar(self, datos):
        # Simulamos la carga de los datos en un destino
        print(f"Cargando datos en el destino de informacion: {self.destino}")
        print(f"Datos cargados: {datos}")
        return datos

class Tuberia:
    def __init__(self):
        self.filtros = []

    def agregar_filtro(self, filtro):
        self.filtros.append(filtro)
    
    def ejecutar(self):
        datos = None
        for filtro in self.filtros:
            datos = filtro.procesar(datos)

# Uso del sistema de tuberías y filtros para ETL
if __name__ == "__main__":
    tuberia = Tuberia()
    tuberia.agregar_filtro(ExtraerDatos('Origen'))
    tuberia.agregar_filtro(TransformarDatos())
    tuberia.agregar_filtro(CargarDatos('destino'))

    tuberia.ejecutar()
