if [ -z $1 ]; then
  echo 'Usage: ./buildDocker.sh imageTag'
  exit 1
fi
docker stop ms-demo-application
 docker rm ms-demo-application
docker rmi $1
cp ../build/libs/ms-demo-application-*jar ./ms-demo-application.jar
docker build -t $1 .
