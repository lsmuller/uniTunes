echo "Criando commmit..."
echo 'Mensagem ' $0

echo "Adicionando..."
git add .

echo "Commitando..."
git commit -m $0

echo "Vai Heroku!"
git push heroku master

echo "Foi..."