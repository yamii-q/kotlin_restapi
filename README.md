# kotlin_restapi + vue-cli
## プロジェクト全体の概要
kotlin(backend) + vue.js(frontend)で簡単なCRUDを作成

## このプロジェクトで行うこと(技術的観点)
 - kotlinの学習
 - axiosを用いたフロント側でのデータ処理の学習
 - docker-composeを用いたローカル環境に依存しない環境構築
 - circleciを用いた自動CI/CD(テストが成功した場合のみ、AWS EC2に自動デプロイ)
 
## クイックスタート
```
git clone git@github.com:yamee-dev/kotlin_restapi.git
docker-compose up --build

# 2回目以降の起動
docker-compose up -d

# 終了
docker-compose down
```
１コマンドのみで、Nginx,Vue.js,Spring,MySqlが立ち上がり、連携する。

 - URL(フロント)
http://localhost:8888/dashboard

 - URL(API)
http://localhost:8081/api/v1/characters
初期状態では空のリストが返却される


## Qiita
kotlinでRESTAPIを作成した部分をまとめた。
https://qiita.com/yamee_dev/items/c2330ae4b000da07c9ad

## 個人的メモ
circleciの自動デプロイは処理時間に難があるため、改善が必要。(コメントアウト済)
docker化出来ているので、ECRにpushしてデプロイした方が良いかもしれない...。
AWSのアーキテクトを勉強する必要がある...。

