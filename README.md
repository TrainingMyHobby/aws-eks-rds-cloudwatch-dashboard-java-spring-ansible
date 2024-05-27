# AWS EKS RDS CloudWatch Dashboard with Java Spring Boot and Ansible

## Overview

This project demonstrates deploying Java Spring Boot microservices to AWS EKS clusters with RDS PostgreSQL databases and monitoring using AWS CloudWatch. The deployment process is automated using Ansible and Maven.

## Project Structure

```plaintext
your-repo/
├── .github/
│   └── workflows/
│       └── build.yml
├── ansible/
│   ├── inventories/
│   │   ├── develop/
│   │   │   └── hosts.yml
│   │   │   └── group_vars/
│   │   │       └── all.yml
│   │   ├── qa/
│   │   │   └── hosts.yml
│   │   │   └── group_vars/
│   │   │       └── all.yml
│   │   ├── demo/
│   │   │   └── hosts.yml
│   │   │   └── group_vars/
│   │   │       └── all.yml
│   │   └── production/
│   │       └── hosts.yml
│   │       └── group_vars/
│   │           └── all.yml
│   ├── playbooks/
│   │   ├── create_eks_cluster.yml
│   │   ├── create_rds.yml
│   │   ├── github_actions_build.yml
│   │   ├── deploy_springboot.yml
│   │   ├── cloudwatch_eks.yml
│   │   ├── cloudwatch_springboot.yml
│   │   └── cloudwatch_rds.yml
│   └── roles/
│       └── common/
│           └── tasks/
│               └── main.yml
├── terraform/
│   ├── develop/
│   │   └── main.tf
│   ├── qa/
│   │   └── main.tf
│   ├── demo/
│   │   └── main.tf
│   └── production/
│       └── main.tf
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── tmh/
│   │   │           └── aws/
│   │   │               └── controller/
│   │   │                   └── TradeController.java
│   │   └── resources/
│   │       ├── application.yaml
│   │       ├── application-develop.yml
│   │       ├── application-qa.yml
│   │       ├── application-demo.yml
│   │       └── application-production.yml
├── pom.xml
└── README.md
```

## Prerequisites
- JDK 21 
- Maven 
- AWS CLI configured with appropriate permissions 
- Terraform 
- Ansible

## Setup
### 1. Clone the Repository
```bash
git clone <this repo URL>
cd aws-eks-rds-cloudwatch-dashboard-java-spring-ansible
```

### 2. Configure AWS and Ansible
Ensure your AWS CLI is configured with appropriate permissions and set up the Ansible inventory files with the correct AWS region, EKS cluster names, RDS details, and other necessary variables.

### 3. Build the Project
Build the project using Maven. The develop profile is active by default and does not run Ansible as part of the build process.

```bash
mvn clean package -Pdevelop
```

### 4. Deploy to Different Environments
To deploy to QA, demo, or production environments, use the respective Maven profiles. These profiles will run the Ansible playbooks to deploy the Spring Boot application to AWS EKS and configure the RDS and CloudWatch dashboards.

##### Deploy to QA or Demo or Production
```bash
mvn clean package -Pqa
mvn clean package -Pdemo
mvn clean package -Pproduction
```

## Application Endpoints
### Trade Management
The TradeController class provides an endpoint for managing trades. The /createTrade endpoint creates a new trade and returns the trade information.

##### Create a New Trade
```bash
curl http://localhost:8080/api/v1/trade-management/createTrade
```

## Ansible Playbooks
### create_eks_cluster.yml
Creates an EKS cluster in the specified AWS region.

### create_rds.yml
Creates an RDS PostgreSQL database.

### github_actions_build.yml
Triggers GitHub Actions workflow to build the Java Spring Boot code.

### deploy_springboot.yml
Deploys the Spring Boot application to the AWS EKS cluster using a blue-green deployment strategy.

### cloudwatch_eks.yml
Creates AWS CloudWatch dashboards for monitoring the EKS cluster.

### cloudwatch_springboot.yml
Creates AWS CloudWatch dashboards for monitoring the Spring Boot application.

### cloudwatch_rds.yml
Creates AWS CloudWatch dashboards for monitoring the RDS PostgreSQL database.


