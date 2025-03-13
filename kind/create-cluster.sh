#!/bin/sh

printf "Initializing Kubernetes cluster..."

kind create cluster --config kind-config.yml

printf "\n-----------------------------------------------------\n"

printf "Installing NGINX Ingress..."

kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml

printf "\n-----------------------------------------------------\n"

printf "Waiting for NGINX Ingress to be ready..."

sleep 10

kubectl wait --namespace ingress-nginx \
  --for=condition=ready pod \
  --selector=app.kubernetes.io/component=controller \
  --timeout=180s

printf "\n"

printf "Happy Sailing!"