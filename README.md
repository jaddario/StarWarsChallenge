# StarWarsChallenge

## Rodando a solução:
Ao baixar a solução, é possível rodá-la utilizando o comando gradle abaixo dentro de {CAMINHO DO DIRETÓRIO}/starwarsproject.
```
gradle bootRun
```
## Adicionando Planetas:
Planetas podem ser adicionados através do método post seguindo a estrutura abaixo.
```json
{
    "nome": "Tatooine",
    "clima": "arido",
    "terreno": "arenoso"
}
```
## Visualizando lista de planetas:
Após a lista de planetas ter sido preenchida, pode-se visualizá-la em http://localhost:8080/starwars/listaplanetas que apresentará uma lista de planetas, já com o número de aparições em filmes adicionada.

## Buscando planetas por id
Pode-se buscar planetas pelo seu id através de um método get no endpoint http://localhost:8080/starwars/buscaplanetapeloid/{id}

## Buscando planetas por nome
Pode-se buscar planetas pelo seu nome através de um método get no endpoint http://localhost:8080/starwars/buscaplanetapeloid/{nome}

## Removendo planetas:
Planetas podem ser removidos pelo seu id utilizando um método delete da forma: http://localhost:8080/starwars/removeplaneta/{ID}.
