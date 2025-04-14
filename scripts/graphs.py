import os
import matplotlib.pyplot as plot
from matplotlib.backends.backend_pdf import PdfPages
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


def obter_testes_disponiveis(structure, languages):

    for lang in languages:

        dir_path = f"../{lang}/out/{structure}"

        if os.path.exists(dir_path):

            return sorted([
                f for f in os.listdir(dir_path)
                if f.endswith(".txt") and os.path.isfile(os.path.join(dir_path, f))
            ])
        
    return []

def plotar_teste(structure, test, pdf, languages, cores_linguagens, cores_pontos):

    plot.figure(figsize=(10, 6))
    legend_pontos = []
    sizes_usado = []

    for lang, cor in zip(languages, cores_linguagens):

        caminho = f"../{lang}/out/{structure}/{test}"
        if not os.path.exists(caminho):
            continue

        sizes, times = read_arquivo(caminho)
        if not sizes or not times:
            continue

        plot.plot(sizes, times, linestyle='-', label=lang, linewidth=1.5, color=cor, zorder=1)

        for i in range(len(sizes)):
            cor_ponto = cores_pontos[i % len(cores_pontos)]
            plot.scatter(sizes[i], times[i], color=cor_ponto, s=20, alpha=1.0, zorder=2)

        if not sizes_usado:
            sizes_usado = sizes[:]

    if sizes_usado:
        legend_pontos = [
            plot.Line2D([0], [0], marker='o', color='w',
                        markerfacecolor=cores_pontos[i % len(cores_pontos)],
                        markersize=8, label=f'Ponto {sizes_usado[i]}')
            for i in range(len(sizes_usado))
        ]

    plot.title(f"Comparação de {test} entre Linguagens - {structure.capitalize()}")
    plot.xlabel("Tamanho do Dataset")
    plot.ylabel("Tempo de Execução (ns)")
    plot.grid(True, alpha=0.5)
    plot.gca().xaxis.set_major_formatter(FuncFormatter(formatar_eixo_x))

    legenda_linguagens = plot.legend(title="Linguagens", loc='best', fontsize='8')
    legenda_pontos = plot.legend(handles=legend_pontos, title="Pontos", loc='upper left', fontsize='8', bbox_to_anchor=(0.125, 1))

    plot.gca().add_artist(legenda_linguagens)
    plot.gca().add_artist(legenda_pontos)
    plot.tight_layout()

    pdf.savefig()
    plot.close()

def gerar_graficos_listas_pdf(languages, cores_linguagens, cores_pontos):

    structures = ["arraylist", "linkedlist"]

    os.makedirs("./out", exist_ok=True)

    for structure in structures:
        pdf_path = f"./out/{structure}.pdf"
        testes = obter_testes_disponiveis(structure, languages)

        if not testes:
            print(f"Nenhum teste encontrado para {structure}")
            continue

        with PdfPages(pdf_path) as pdf:
            for test in testes:
                plotar_teste(structure, test, pdf, languages, cores_linguagens, cores_pontos)

        print(f"Gráficos salvos em {pdf_path}")

def gerar_graficos_mapas_pdf(languages, cores_linguagens, cores_pontos):

    structures = ["hashmap"]

    os.makedirs("./out", exist_ok=True)

    for structure in structures:
        pdf_path = f"./out/{structure}.pdf"
        testes = obter_testes_disponiveis(structure, languages)

        if not testes:
            print(f"Nenhum teste encontrado para {structure}")
            continue

        with PdfPages(pdf_path) as pdf:
            for test in testes:
                plotar_teste(structure, test, pdf, languages, cores_linguagens, cores_pontos)

        print(f"Gráficos salvos em {pdf_path}")

def gerar_graficos_trees_pdf(languages, cores_linguagens, cores_pontos):

    structures = ["avltree"]

    os.makedirs("./out", exist_ok=True)

    for structure in structures:
        pdf_path = f"./out/{structure}.pdf"
        testes = obter_testes_disponiveis(structure, languages)

        if not testes:
            print(f"Nenhum teste encontrado para {structure}")
            continue

        with PdfPages(pdf_path) as pdf:
            for test in testes:
                plotar_teste(structure, test, pdf, languages, cores_linguagens, cores_pontos)

        print(f"Gráficos salvos em {pdf_path}")

if __name__ == "__main__":

    languages = ["C", "Java", "Python", "Go", "Kotlin"]
    cores_linguagens = ['black', 'orange', 'cyan', 'navy', 'olive']
    cores_pontos = [
                    'red', 'orangered', 'orange', 'gold', 'yellow',
                    'greenyellow', 'limegreen', 'green', 'turquoise',
                    'cyan', 'deepskyblue', 'blue', 'slateblue',
                    'purple', 'magenta', 'deeppink']

    gerar_graficos_listas_pdf(languages, cores_linguagens, cores_pontos)
    gerar_graficos_mapas_pdf(languages, cores_linguagens, cores_pontos)
    gerar_graficos_trees_pdf(languages, cores_linguagens, cores_pontos)  