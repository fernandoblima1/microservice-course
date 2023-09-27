configure:
	@ echo 'Criando arquivo .env a partir do env.exemplo...'
	@ [ ! -f ".env" ] && cp .env.exemplo .env || true
	@ echo 'Dando permissao de execucao ao binario mvnw...'
	@ chmod +x mvnw

start: configure
	@ export $$(cat .env | grep -v '^#' | xargs) && ./mvnw -s scripts/settings.xml spring-boot:run

