# Test-case Tinkoff Translator

## Описание проекта

Проект был полностью переписан с учетом заявленных недостатков

## Запуск приложения

1. Клонируйте репозиторий
```sh 
git clone https://github.com/Papugaicheg/translator_v2
```

2. Запустите процесс изображения
```sh 
docker build  --build-arg ApiKey=<IAM-token> -t translator .
```

3. Запустите новый контейнер 
```sh 
 docker run -p 8080:8080 translator_v2
```

## Входные данные
POST api/translate

* inputString - строка, которую нужно перевести
* translateParameters - пара языков, где первый - исходный, а второй - на который надо перевести

Пример входных данных:

```json
{
  "inputString": "wing chicken apple",
  "translateParameters": "en-ru"
}
```

## Выходные данные

* translatedText - переведенная строка

Пример выходных данных:

```json
{
    "translatedText": "крыло курица яблоко"
}
```


