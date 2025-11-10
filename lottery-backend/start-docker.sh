#!/bin/bash

# ============================================
# Script de Inicio Automático - Backend Lotería
# ============================================

set -e  # Detener en caso de error

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Banner
echo ""
echo -e "${BLUE}╔═══════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${BLUE}║                                                                   ║${NC}"
echo -e "${BLUE}║      SISTEMA DE VENTA DE BILLETES DE LOTERÍA                      ║${NC}"
echo -e "${BLUE}║                                                                   ║${NC}"
echo -e "${BLUE}║       Iniciando con Docker...                                     ║${NC}"
echo -e "${BLUE}║                                                                   ║${NC}"
echo -e "${BLUE}╚═══════════════════════════════════════════════════════════════════╝${NC}"
echo ""

# Verificar que Docker está instalado
echo -e "${YELLOW}[1/5]${NC} Verificando Docker..."
if ! command -v docker &> /dev/null; then
    echo -e "${RED}❌ Docker no está instalado${NC}"
    echo -e "${YELLOW}Por favor instala Docker Desktop desde: https://www.docker.com/products/docker-desktop${NC}"
    exit 1
fi
echo -e "${GREEN}✅ Docker encontrado${NC}"

# Verificar que Docker Compose está instalado
echo -e "${YELLOW}[2/5]${NC} Verificando Docker Compose..."
if ! command -v docker-compose &> /dev/null; then
    echo -e "${RED}❌ Docker Compose no está instalado${NC}"
    exit 1
fi
echo -e "${GREEN}✅ Docker Compose encontrado${NC}"

# Verificar que Docker daemon está corriendo
echo -e "${YELLOW}[3/5]${NC} Verificando Docker daemon..."
if ! docker info &> /dev/null; then
    echo -e "${RED}❌ Docker daemon no está corriendo${NC}"
    echo -e "${YELLOW}Por favor inicia Docker Desktop${NC}"
    exit 1
fi
echo -e "${GREEN}✅ Docker daemon corriendo${NC}"

# Detener contenedores previos si existen
echo -e "${YELLOW}[4/5]${NC} Limpiando contenedores previos..."
docker-compose down 2>/dev/null || true
echo -e "${GREEN}✅ Listo${NC}"

# Construir y ejecutar
echo -e "${YELLOW}[5/5]${NC} Construyendo y ejecutando aplicación..."
echo -e "${BLUE}Esto puede tomar unos minutos la primera vez...${NC}"
echo ""

docker-compose up --build

# Este punto solo se alcanza si el usuario presiona Ctrl+C
echo ""
echo -e "${GREEN}✅ Aplicación detenida correctamente${NC}"