# Normalize-Email Java Library

Welcome to the **normalize-email** library! This Java library provides a 
straightforward way to normalize email addresses by applying various strategies 
for popular email domains. It supports built-in strategies for Gmail, Outlook, Live, 
and Hotmail, and also allows users to define and modify their own normalization 
strategies. If an email domain does not have a predefined strategy, a default strategy 
is applied.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [License](#license)
- [Contact](#contact)

## Features

- **Built-in Strategies:** Normalization strategies for Gmail, Outlook, Live, and Hotmail.
- **Custom Strategies:** Ability to add and modify normalization strategies based on user needs.
- **Default Strategy:** Automatically applies a default normalization strategy for unsupported email domains.
- **Flexible Integration:** Easily integrate into your existing Java projects.

## Getting Started

To get started with EmailNormalizer, follow these instructions:

1. **Add the Dependency**

   Add the following dependency to your `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.example</groupId>
       <artifactId>normalize-email</artifactId>
       <version>0.0.1</version>
   </dependency>

## Usage

### Basic Usage

Here’s a quick example of how to use normalize-email:
    
    public class Main {
        public static void main(String[] args) {
            // Create an instance of EmailNormalizerImpl
            EmailNormalizerImpl normalizer = new EmailNormalizerImpl();
            
            // Normalize an email address
            String normalizedEmail = normalizer.normalize("example@gmail.com");
            System.out.println("Normalized Email: " + normalizedEmail);
        }
    }


### Adding Custom Strategies

You can add custom normalization strategies by implementing the `EmailNormalizationStrategy` interface and registering it with `EmailNormalizationImpl`. Here’s how you can do it:

**Implement the `EmailNormalizationStrategy` Interface**

   Create a class that implements the `EmailNormalizationStrategy` interface and provides the logic for your custom normalization.


    
       public class CustomNormalizationStrategy implements NormalizationStrategy {
           @Override
           public String normalizeEmailString(String localPart, String domain) {
               // Implement custom normalization logic here
               return localPart + "@" +domain;
           }
       }

### License
This project is licensed under the MIT License.

### Contact
For questions or feedback open an issue, or, please contact us at contact@pinggy.io
