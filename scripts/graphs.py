import os
import matplotlib.pyplot as plot
from matplotlib.ticker import FuncFormatter

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
    
    return sizes, times

def formatar_eixo_x(x, pos):
    if x >= 1_000_000:
        return f'{x / 1_000_000}M'
    elif x >= 1_000:
        return f'{x / 1_000}k'
    else:
        return f'{int(x)}'

def plotar_grafico():
    languages = ["C", "Java", "Python", "Go", "Kotlin"]
    
    cores_linguagens = ['black', 'orange', 'cyan', 'navy', 'olive']
    cores_pontos = ['red', 'orange', 'gold', 'yellow', 'green', 'turquoise', 'cyan', 'blue', 'purple', 'magenta']

    plot.figure(figsize=(10, 6))


    for language, cor in zip(languages, cores_linguagens):    
        caminho = f"C:/Users/jamqu/Projects/StructComparisons/{language}/out/insertion_first_elemento_unico.txt"

        sizes, times = read_arquivo(caminho)

        if sizes and times:
            plot.plot(sizes, times, linestyle='-', label=f"{language}", linewidth=1.5, zorder=1, color=cor)

            for i in range(len(sizes)):
                plot.scatter(sizes[i], times[i], color=cores_pontos[i], s=20, alpha=1.0, zorder=2)

            legend_pontos = []
            for i in range(0, len(sizes), len(sizes)//5):
                legend_pontos.append(plot.Line2D([0], [0], marker='o', color='w', markerfacecolor=cores_pontos[i], markersize=8, label=f'Ponto {sizes[i]}'))


        plot.title("Comparação de Inserção entre Linguagens")
        plot.ylabel("Tempo de Execução (microsegundos)")
        plot.xlabel("Tamanho do Dataset")

        plot.gca().xaxis.set_major_formatter(FuncFormatter(formatar_eixo_x))

        legenda_linguagens = plot.legend(title="Linguagens", loc='best', fontsize='8')
        legenda_pontos = plot.legend(handles=legend_pontos, title="Pontos", loc='upper left', fontsize='8', bbox_to_anchor=(0.125, 1))

        plot.gca().add_artist(legenda_linguagens)
        plot.gca().add_artist(legenda_pontos)

        plot.grid(True, alpha=0.5)

    plot.show()

if __name__ == "__main__":
    plotar_grafico()
