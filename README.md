
projeto final que tem como objetivo avaliar e mostrar os conhecimento adquiridos no curso de aceleração java da Trybe em conjunto com a Hub Floripa.
projeto feito com a ajuda de Leticia De Paula e Juliana Miranda.

capaz de fazers transportes de pequenas cargas Drone Feeder está munido de uma interface amigavel ao usuario em que se pode ter informações como localização do drone,
histórico de entregas, status da entrega atual e gravações feito por ele.

como testar?

clone o repositorio git:
no seu terminal de o comando: git clone git@github.com:LeonardoKarate/Grupo7.git

entre no repositorio:
no seu terminal de o comando: cd Drone-Feeder

instales as dependencias:
no seu terminal de o comando: mvn install.

para iniciar sua aplicação:
no seu terminal de o comando: mvn spring-boot:run

rotas:
recomendamos o uso do programa postman para fazer requisições.

método get /drone:
retorna uma lista com todos os drone.

método get /drone/id
retorna o drona com o id especificado.

método post /drone
corpo de requisição:
{
    "latitude": String,
    "longitude": String,
    "entrega": {
        "endereco": String,
        "status": Status,
        "descricao": String,
        "videoUrl": String
    }
}
cria e adiciona um drone no banco de dados.
retorna o drone criado.

método put /drone/id
corpo da requisição:
{
    "latitude": String,
    "longitude": String,
    "entrega": {
        "endereco": String,
        "status": Status,
        "descricao": String,
        "videoUrl": String
    }
}
altera o drone com o id especificado.
retorna o drone alterado.

método delete /drone/id
deleta o drone com id especificado

método get /drone/id/entrega:
retorna uma lista com todas entregas do drone especificado

método get /drone/id/entrega/id
retorna a entrega epecificada do drone especificado

método post /drone/id/entrega
corpo de requisição:
{
    "endereco": String,
    "status": Status,
    "descricao": String,
    "videoUrl": Stringg
}
cria e adiciona uma entrega no banco de dados.
retorna a entrega criada.

método put /drone/id/entrega/id
corpo da requisição:
{
    "endereco": String,
    "status": Status,
    "descricao": String,
    "videoUrl": String
}
altera a entrega com o id especificado.
retorna a entrega alterada.

método delete /drone/id/entrega/id
deleta a entrega com id especificado

método get /drone/id/entrega/id/videos
retorna todos os videos da entrega especificada

método get /drone/id/entrega/id/videos/id
retorna o videos especificada da entrega especificada

método patch /drone/id/entrega/id
corpo da requisição:
{
    "status": status
}
altera o status da entrega

método patch /drone/id/entrega/id/video
corpo da requisição:
{
    "video": string
}
adiciona video da entrega especificada

casos de falhas:

adicionar drone com id especifico:
retorno "não pode criar drone com id especifico" status 400

fazer requisição para um drone que não existe:
retorn "Drone não encontrado" status 404
