# afactu

Application de facturation. Monorepo regroupant les deux modules du projet, historiquement
répartis dans deux dépôts distincts (`afactu` et `afactu-web`), fusionnés ici sans perte
d'historique.

## Modules

| Dossier | Artifact Maven | Rôle |
|---|---|---|
| `afactu/` | `com.aroolia.afactu:core:1.0-SNAPSHOT` | Cœur métier : entités, services, repositories (JdbcTemplate) |
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

> **Piège connu.** Sauter la première commande fait travailler `afactu-pro` sur un jar `core`
> périmé. Selon l'ancienneté du jar, cela se manifeste par un
> `NoSuchBeanDefinitionException: No qualifying bean of type 'InvoiceServiceInterface'` au
> démarrage, ou par des comportements incohérents avec le code source visible dans l'IDE.

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

Contrainte de validation à connaître : `orderNumber` doit faire entre 6 et 10 caractères.
