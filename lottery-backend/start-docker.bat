@echo off
REM ============================================
REM Script de Inicio Automático - Backend Lotería
REM ============================================

color 0B

echo.
echo ============================================================
echo.
echo    Sistema de Venta de Billetes de Loteria
echo.
echo    Iniciando con Docker...
echo.
echo ============================================================
echo.

REM Verificar que Docker está instalado
echo [1/5] Verificando Docker...
docker --version >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Docker no esta instalado
    echo Por favor instala Docker Desktop desde: https://www.docker.com/products/docker-desktop
    pause
    exit /b 1
)
echo [OK] Docker encontrado
echo.

REM Verificar que Docker Compose está instalado
echo [2/5] Verificando Docker Compose...
docker-compose --version >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Docker Compose no esta instalado
    pause
    exit /b 1
)
echo [OK] Docker Compose encontrado
echo.

REM Verificar que Docker daemon está corriendo
echo [3/5] Verificando Docker daemon...
docker info >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Docker daemon no esta corriendo
    echo Por favor inicia Docker Desktop
    pause
    exit /b 1
)
echo [OK] Docker daemon corriendo
echo.

REM Detener contenedores previos si existen
echo [4/5] Limpiando contenedores previos...
docker-compose down >nul 2>&1
echo [OK] Listo
echo.

REM Construir y ejecutar
echo [5/5] Construyendo y ejecutando aplicacion...
echo Esto puede tomar unos minutos la primera vez...
echo.

docker-compose up --build

echo.
echo Aplicacion detenida correctamente
pause