apiVersion: apps/v1
kind: Deployment
metadata:
  name: #{APP_NAME}#
  namespace: #{NAMESPACE}#
  labels:
    app: #{APP_NAME}#
    appversion: '#{IMG_VERSION}#'
spec:
  replicas: 1
  selector:
    matchLabels:
      app: #{APP_NAME}#
  template:
    metadata:
      labels:
        app: #{APP_NAME}#
      annotations:
        prometheus.io/scrape: 'true'
        prometheus.io/path: '/testapp/actuator/prometheus'
    spec:
      containers:
      - name: log#{LOG_FLAGS}#-#{APP_NAME}#
        image: '#{DOCKER_REGISTRY_URL}#/#{ORG_NAME}#/#{PROJECT_NAME}#/#{APP_NAME}#:#{IMG_VERSION}#'
        imagePullPolicy: Always
        ports:
        - containerPort: 8080
