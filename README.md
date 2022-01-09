# ESGI AL2 - Florian Gustin - CC1

Created: November 21, 2021 10:50 PM

# Pré-requis :

- Java 11
- Maven

# Concept & Patterns

 - Value Object
 - Value Object ID
 - Repository
 - Service
 - Manager
 - Entity
 - Aggregate
 - Factory
 - Event
 - Command
 - CommandBus
 - Query
 - QueryBus
 - EventDispatcher
 - CommandHandler
 - QueryHandler

# Architecture

 - SEDA :
   - J'ai essayé d'intégrer l'architecture SEDA, afin d'émettre un maximum d'EVENT pour rendre l'application Reactive.
 - CQRS :
   - J'utilise un model de logique de type CQRS, j'émets une COMMAND OU QUERY et peut en attendre un retour ou non.
 - EVENT SOURCING :
   - J'ai essayé de me familiariser avec l'EVENT SOURCING par la même occasion. Il pourra être difficile d'effectuer des recherches spécifiques par ce biai.

# En cours de contruction

J'ai pour but de mieux maitriser les BUS d'événements afin d'avoir une application trés modulaire. Je pense davantage renforcer l'aspect BackBoneHub qui est sous utilisé à présent.


# Conclusion

J'aurais pu évidemment pu mieux faire, mais mon but était vraiment de me concentrer sur les architectures vu en cours. Autant faire moins complet, un peu moins propre (j'entends par la les Builders, les static Factory, etc...) que j'avais démontré lors du CC1 mais se concentrer sur les clés de voutes qui sont bien plus intéréssantes.
Les tests toujours par manque de temps, je ne m'y suis pas encore attelé. 
Sinon j'ai refait entièrement l'application, j'ai exposé les endpoints comme demandé et j'ai crée l'abonnement ainsi que son renouvellement.
    