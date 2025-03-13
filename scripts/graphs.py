import os
import matplotlib.pyplot as plot

def read_arquivo(caminho):
    
    sizes = []
    times = []
    
    try:
        with open(caminho, 'r') as arquivo:
            for linha in arquivo:
                if not linha.strip():
                    continue
                
                elementos = linha.strip().split(';')
                
                if len(elementos) == 2:
                    try:
                        size = int(elementos[0])
                        time = float(elementos[1])
                        sizes.append(size)
                        times.append(time)
                
                    except ValueError:
                        continue

    except FileNotFoundError:
        print(f"Arquivo não encontrado: {caminho}")
    
    print(sizes)
    return sizes, times

def generate_insertion_comparison():
    languages = ["C", "Java", "Python"]
    
    plot.figure(figsize=(10, 6))
    
    caminho = "C:/Users/jamqu/Projects/StructComparisons/C/out/insertion_end.txt"
    
    sizes, times = read_arquivo(caminho)
    
    if sizes and times:
        plot.plot(sizes, times, label="teste")
    
    plot.title("Comparação de Inserção entre Linguagens")
    plot.xlabel("Tamanho do Dataset")
    plot.ylabel("Tempo de Execução (microsegundos)")
    plot.legend()
    plot.grid(True)
    
    plot.show()

if __name__ == "__main__":
    generate_insertion_comparison()
