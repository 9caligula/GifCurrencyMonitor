## GifCurrencyMonitor

Cервис, который обращается к сервису курсов валют, и отображает gif:

• если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich

• если ниже - отсюда https://giphy.com/search/broke

## EndPoints:

Сервис доступен по http://localhost:9090/

Получить список всех валют - GET: / или /currencies

Получить гифку по заданному коду валюты - GET: /getGif/{code}

## Прочее

Запустить jar-файл можно при помощи java -jar GifCurrencyMonitor-0.0.1-SNAPSHOT.jar

UI сделан при помощи Thymeleaf
