# Specification v0.1

## 01. API - Classifications register

### Description
Create a register for phylum, class, order, family, genus and specie. It's necessary the classifications register in the respective order. Example: For register an order necessary register a class previously.

![SPECIE_CLASSIFICATION](images/PROJECT_ZERU_SPECIE_CLASSIFICATION.png)

### Models

#### MD-01 Phylum
    {
        idPhylum: 01,
        dsPhylum: "Phylum Example"
    }

#### MD-02 Class
    {   
        idPhylum: 01,
        idClass: 01,
        dsClass: "Class Example"
    }

#### MD-03 Order
    {
        idClass: 01,
        idOrder: 01,
        dsOrder: "Order Example"
    }

#### MD-04 Family
    {
        idOrder: 01,
        idFamily: 01,
        dsFamily: "Family Example"
    }

#### MD-05 Genus
    {
        idFamily: 01,
        idGenus: 01,
        dsGenus: "Genus Example"
    }

#### MD-06 Specie
    {
        idGenus: 01,
        idSpecie: 01,
        nmSpecie: "Specie Example",
        nmnCommon: "Common name Example",
        idSIBBR: "3312"
    }


### Rules

#### RL-01
If there is no parent classification select focus for the parent register.

#### RL-02
Within the classification can't duplicate name.