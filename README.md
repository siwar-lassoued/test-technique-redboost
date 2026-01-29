# 🚀 Test Technique RedBoost - Gestion de Factures et Devis

Application web de gestion de factures et devis développée avec **Spring Boot** et **Angular**.

## 📋 Fonctionnalités

### ✅ Gestion des Factures
- Création de factures avec calcul automatique de la TVA
- Affichage de la liste des factures
- Suppression de factures
- Génération automatique du numéro de facture
- Calcul automatique du montant TTC (HT + TVA)

### ✅ Gestion des Devis
- Création de devis avec génération automatique du numéro
- Gestion des statuts : En attente, Accepté, Refusé
- Affichage de la liste des devis avec statistiques
- Mise à jour du statut en temps réel
- Date de validité automatique (30 jours)
- Détection des devis expirés

## 🛠️ Technologies utilisées

### Backend
- **Spring Boot 3.x**
- **Java 17+**
- **Spring Data JPA**
- **Base de données H2** (en mémoire)
- **Maven**
- **Lombok**

### Frontend
- **Angular 15**
- **TypeScript**
- **Bootstrap 5**
- **Bootstrap Icons**
- **RxJS**

## 📦 Structure du projet
```
test-technique/
├── backend/                    # Backend Spring Boot
│   └── src/main/java/tn/redboost/facture/
│       ├── model/             # Entités JPA
│       ├── repository/        # Repositories
│       ├── service/           # Services métier
│       ├── controller/        # Contrôleurs REST
│       └── config/            # Configuration CORS
│
└── frontend/                   # Frontend Angular
    └── redboost-facture-app/
        └── src/app/
            ├── models/        # Interfaces TypeScript
            ├── services/      # Services HTTP
            └── components/    # Composants Angular
```

## 🚀 Installation et lancement

### Prérequis
- Java 17+
- Node.js 18+
- Maven 3.8+
- Angular CLI 15+

### Backend (Spring Boot)
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

Le backend sera accessible sur : **http://localhost:8080**

### Frontend (Angular)
```bash
cd frontend/redboost-facture-app
npm install
ng serve
```

Le frontend sera accessible sur : **http://localhost:4200**

## 🔗 API Endpoints

### Factures
- `GET /api/factures` - Liste toutes les factures
- `GET /api/factures/{id}` - Récupère une facture par ID
- `POST /api/factures` - Crée une nouvelle facture
- `DELETE /api/factures/{id}` - Supprime une facture

### Devis
- `GET /api/devis` - Liste tous les devis
- `GET /api/devis/{id}` - Récupère un devis par ID
- `POST /api/devis` - Crée un nouveau devis
- `PATCH /api/devis/{id}/statut` - Met à jour le statut d'un devis
- `DELETE /api/devis/{id}` - Supprime un devis

## 🎨 Design

Le design s'inspire de la plateforme **RedBoost** (www.redboost.tn) avec :
- Palette de couleurs : Rouge (#b93f5c), Bleu foncé (#2c3e50), Bleu accent (#1a4d6d)
- Interface moderne et responsive
- Animations fluides
- Cartes avec effet de survol

## 📊 Base de données

La base de données H2 est configurée en mode **mémoire** pour faciliter les tests.

### Console H2
- URL : http://localhost:8080/h2-console
- JDBC URL : `jdbc:h2:mem:testdb`
- Username : `sa`
- Password : *(vide)*

## ✨ Fonctionnalités avancées

- **Calcul automatique** : TVA et montant TTC pour les factures
- **Génération automatique** : Numéros de factures et devis
- **Validation** : Dates et montants
- **Statistiques** : Compteurs par statut pour les devis
- **Détection d'expiration** : Indicateur visuel pour les devis expirés

## 👨‍💻 Auteur

**Siwar** - Test technique pour RedBoost

## 📝 Licence

Ce projet est réalisé dans le cadre d'un test technique.