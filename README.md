# Validador de Senhas Bancárias

## Tecnologias
- Java 17
- Spring Boot 3.2
- Log4j2
- JUnit 5

## Como Executar
```bash
mvn spring-boot:run
```

## Endpoints
| Método | Endpoint               | Descrição          |
|--------|------------------------|--------------------|
| POST   | `/api/v1/password/validate` | Valida uma senha |

## Requisitos de Senha
- Mínimo 9 caracteres
- 1 caractere especial (!@#$%^&*)
- Sem caracteres repetidos

## Detalhes sobre a sua solução

## A Arte da Engenharia de Software: 
- Um Approach Estratégico, pragmática e focada em resultados no desenvolvimento do Validador de Senhas Bancárias

Na construção de um Validador de Senhas Bancárias, não basta apenas cumprir requisitos técnicos; 
é necessário dominar a arte da engenharia de software com estratégia, pragmatismo e visão de longo prazo. 
Assim como um príncipe deve equilibrar poder e virtù, um arquiteto de software deve equilibrar rigor técnico e praticidade.

A seguir, desvendamos as decisões cruciais do projeto, inspiradas nos princípios de Estratégia:

## 1. Testes de Unidade e Integração: A Disciplina da Guerra

Testes de Unidade (Rigor Implacável)

Cada regra de validação foi testada isoladamente, garantindo que falhas não passem despercebidas.

Verifica cada condição (tamanho, caracteres especiais, repetição) com cenários extremos.

Objetivo: Eliminar vulnerabilidades antes que se tornem falhas catastróficas.

Testes de Integração (Estratégia de Domínio)

O simulamos requisições HTTP reais, garantindo que o sistema opere como um todo.

Objetivo: Assegurar que, mesmo em combate (produção), o sistema não traia suas promessas.

## 2. Abstração, Acoplamento, Extensibilidade e Coesão: 
  
Abstração (Domínio Puro)

PasswordValidatorPort é uma interface, não uma implementação. Isso permite que o domínio permaneça soberano, independente de frameworks ou bancos de dados.

Benefício: O núcleo do negócio não se corrompe com detalhes técnicos.

Baixo Acoplamento 

O ValidatePasswordUseCase não conhece HTTP, JSON ou bancos de dados. Ele só sabe validar senhas.

Benefício: Se o banco mudar de REST para GraphQL, o domínio permanece intocado.

Extensibilidade 

Novas regras (ex.: "não pode conter sequências comuns") são adicionadas sem modificar o código existente (Open/Closed Principle).

Benefício: O sistema evolui sem revoluções sangrentas.

Alta Coesão (Foco na Missão)

PasswordRules só faz uma coisa: valida senhas. Não se distrai com logging, persistência ou UI.

Benefício: Manutenção simplificada e clareza de propósito.

## 3. Design de API: A Diplomacia do Poder

Endpoint RESTful (POST /api/v1/password/validate)

Clareza: Segue o padrão REST, com versionamento explícito (v1).

Segurança: Nunca expõe detalhes internos.

Consistência: Respostas padronizadas (ex.: { "isValid": boolean }).

DTOs Imutáveis (PasswordValidationRequest, PasswordValidationResponse)

Controle: Garante que apenas dados válidos entrem no sistema.

Simplicidade: Elimina complexidade desnecessária.

## 4. Clean Code: A Virtù do Artesão

Nomes Significativos

hasNoRepeatedChars é melhor que checkRule3.

Funções Pequenas e Especializadas

Cada método em PasswordRules faz uma coisa bem.

Ausência de Mágica

Constantes como MIN_PASSWORD_LENGTH = 9 são nomeadas, não hardcoded.

Documentação Clara

JavaDoc explica o "porquê", não apenas o "como".

## 5. SOLID: As Leis Imutáveis do Poder
   "Aquele que menos confia na sorte é o menos vulnerável."

Princípio	Aplicação no Validador de Senhas
Single Responsibility	PasswordRules só valida senhas, não persiste ou loga.
Open/Closed	Novas regras são adicionadas sem modificar código existente.
Liskov Substitution	Qualquer implementação de PasswordValidatorPort se comporta consistentemente.
Interface Segregation	A interface expõe apenas isValid(), sem métodos desnecessários.
Dependency Inversion	O controller depende da interface (PasswordValidatorPort), não da implementação.
Conclusão: O Príncipe do Código
Assim como Maquiavel ensinou que um líder deve equilibrar virtù (habilidade) e fortuna (sorte), um sistema bancário deve equilibrar rigor técnico e adaptabilidade.

Nosso Validador de Senhas não é apenas código—é uma estratégia de dominação técnica, onde:

As regras são claras (documentação e testes),

O poder é descentralizado (baixo acoplamento),

A evolução é inevitável (extensibilidade).

Para reinar no mundo do software, não basta ser competente—é preciso ser estratégico.