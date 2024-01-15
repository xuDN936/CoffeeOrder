# Noms et e-mails des membres degroupe：
 Groupe: 徐丹妮 Alix      1201024036   github-name：xuDN936    email：2879774048@qq.com; 
         毛湘   Véronica  1201024037   github-name：MaoXiang1  email：783175542@qq.com;


# Système de Gestion du Café

## Présentation du Projet

Le Système de Gestion du Café est un système simple de gestion des commandes de café, conçu pour fournir des fonctionnalités de création et de suppression de commandes de café via des services web RESTful. Ce système intègre également un service externe d'informations sur les films (OMDb API), permettant de fournir des informations sur les films tout en offrant des services de café aux clients.

## Objectifs

L'objectif global du projet est de mettre en place un système de commande de café flexible permettant aux cafés de servir les clients qui regardent des films. Les objectifs spécifiques comprennent :

- Fournir une API RESTful simple pour la création et la suppression de commandes de café.
- Intégrer un service externe d'informations sur les films pour obtenir des détails liés aux films tout en servant du café.

## Composants

Le projet est principalement composé des éléments suivants :

1. **Service de Commande de Café :**
   - Un service chargé de la gestion des commandes de café, fournissant des fonctionnalités de création et de suppression de commandes.
   - Implémente des opérations CRUD de base, notamment la récupération de toutes les commandes, la récupération d'une commande spécifique, la création et la suppression de commandes.

2. **Ressource de Commande de Café :**
   - Une classe de ressources de services web RESTful, traitant les requêtes HTTP liées aux commandes de café.
   - Utilise les annotations JAX-RS (Java API for RESTful Web Services) et fournit des services via une configuration de Servlet.

3. **Service d'Informations Externes sur les Films :**
   - Utilise un service REST externe (OMDb API) pour obtenir des informations sur les films.
   - Utilisé pour fournir des détails sur les films actuellement diffusés tout en offrant des services de café.

# Description des Services

## Service de Commande de Café

Le Service de Commande de Café fournit les fonctionnalités suivantes :

- **Obtenir Toutes les Commandes de Café :** Retourne la liste de toutes les commandes de café actuelles via une requête GET.

- **Obtenir une Commande de Café Spécifique :** Retourne les détails d'une commande spécifique en fonction de son ID via une requête GET.

- **Créer une Commande de Café :** Crée une nouvelle commande de café à l'aide d'une requête POST et de données JSON. Retourne une réponse JSON contenant les informations de la nouvelle commande.

- **Supprimer une Commande de Café :** Supprime une commande de café spécifique en fonction de son ID via une requête DELETE.

## Ressource de Commande de Café

La Ressource de Commande de Café fournit des services web RESTful via une configuration de Servlet, traitant les requêtes HTTP liées aux commandes de café. Les paramètres de configuration principaux incluent :

- **jaxrs.serviceClasses :** Spécifie le nom de classe qualifié complet de la classe de ressources JAX-RS, ici `coffee.management.web.resource.CoffeeOrderResource`.

- **jaxrs.address :** Spécifie le chemin d'URI de base des services JAX-RS, ici `/api`.

## Service d'Informations Externes sur les Films

Le service d'informations externes sur les films utilise l'API OMDb pour obtenir des détails sur un film spécifique. Dans ce projet, ce service est utilisé pour obtenir des informations sur le film actuellement diffusé, offrant ainsi un divertissement supplémentaire aux clients du café.

# Description des Clients

Les clients principaux sont le personnel de service du café et les clients du café. Le personnel de service peut gérer les commandes de café via le Service de Commande de Café, tandis que les clients peuvent obtenir des informations sur le film actuellement diffusé tout en savourant leur café.

# Exemple d'Utilisation

## Créer une Commande de Café

Le personnel de service utilise le système pour créer une commande de café, par exemple :

```java
CoffeeOrder espressoOrder = new CoffeeOrder();
espressoOrder.setCoffeeName("espresso");
espressoOrder.setPrice(2.5);
espressoOrder.setQuantity(1);

createCoffeeOrder(espressoOrder);
```

Le système affiche les détails de la commande, indiquant que la commande a été créée avec succès.

## Supprimer une Commande de Café

Le personnel de service peut supprimer une commande de café spécifique en utilisant l'ID de commande, par exemple :

```java
deleteCoffeeOrder(1); //
```
