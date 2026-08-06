# afactu

Application de facturation. Monorepo regroupant les deux modules du projet, 
Répartis dans deux dépôts distincts (`afactu` et `afactu-web`).

## Modules

| Dossier | Artifact Maven | Rôle |
|---|---|---|
| `afactu/` | `com.aroolia.afactu:core:1.0-SNAPSHOT` | Cœur métier : entités, services, repositories |
| `afactu-pro/` | `com.aroolia.afactu:afactu-pro:0.0.1-SNAPSHOT` | Application Spring Boot : contrôleurs web + REST, templates Thymeleaf |

`afactu-pro` déclare une dépendance vers l'artifact `core`, qu'il résout depuis le dépôt Maven
local `~/.m2`.

## Build : l'ordre est obligatoire

Il n'y a **pas** de POM agrégateur à la racine : les deux modules se construisent séparément, et
`core` doit être installé dans `~/.m2` **avant** toute construction d'`afactu-pro`.

```bash
mvn -f afactu/pom.xml clean install        # 1. installe core dans ~/.m2
mvn -f afactu-pro/pom.xml spring-boot:run  # 2. lance l'application
```

## Configuration

`afactu-pro/src/main/resources/application.properties` :

- `server.port=80`, `server.servlet.context-path=/afactu`
- Datasource MySQL : base `invoise` sur `localhost:3306`

L'application est alors accessible sur `http://localhost/afactu/invoice/home`.

## Endpoints

| Méthode | URL | Description |
|---|---|---|
| `GET` | `/afactu/invoice/home` | Page listant les factures |
| `GET` | `/afactu/invoice/create-form` | Formulaire de création |
| `POST` | `/afactu/invoice/create` | Création d'une facture |
| `GET` | `/afactu/invoice` | Liste des factures en JSON |
