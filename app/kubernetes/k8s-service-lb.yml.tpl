kind: Service
apiVersion: v1
metadata:
  namespace: #{NAMESPACE}#
  name: #{APP_NAME}#
  annotations:
    service.beta.kubernetes.io/azure-load-balancer-internal: "true"  
spec:
  type: LoadBalancer
  selector:
    app: #{APP_NAME}#
  ports:
  - name: application
    protocol: TCP
    port: #{SERVICE_PORT}#
    targetPort: #{TARGET_PORT}#
  - name: management
    port: 8081
    protocol: TCP
    targetPort: 8081