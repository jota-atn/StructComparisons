import os
import matplotlib.pyplot as plot
import matplotlib.lines as mlines

def read_arquivo(caminho):
    
    sizes = []
    times = []
    
    try:
        with open(caminho, 'r', encoding='utf-8') as arquivo:
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
    
    print(sizes, times)
    return sizes, times

def plotar_grafico():
    languages = ["C", "Java", "Python", "Go", "Kotlin"]
    
    cores_linguagens = ['black', 'orange', 'cyan', 'navy', 'olive']
    cores_pontos = ['green', 'blue', 'red', 'pink', 'purple']

    plot.figure(figsize=(10, 6))

   
    for language, cor in zip(languages, cores_linguagens):    
        caminho = f"C:/Users/jamqu/Projects/StructComparisons/{language}/out/insertion_last.txt"

        sizes, times = read_arquivo(caminho)

        if sizes and times:
            plot.plot(sizes, times, linestyle='-', label=f"{language}", linewidth=1.5, zorder=1, color=cor)

            for i in range(len(sizes)):
                plot.scatter(sizes[i], times[i], color=cores_pontos[i ], s=20, alpha=1.0, zorder=2)


        plot.title("Comparação de Inserção entre Linguagens")
        plot.ylabel("Tempo de Execução (microsegundos)")
        plot.xlabel("Tamanho do Dataset")
        plot.legend(title="Linguagens", loc='best', fontsize='8')
     
        plot.grid(True, alpha=0.5)

    plot.show()

if __name__ == "__main__":
    plotar_grafico()
