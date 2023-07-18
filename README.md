# Microservice-using-consult

Microservice spring boot using consul

## To Start services

- Start consul sh`./consul/start.sh`
    - Install vault
        - On mac
          ```sh
          brew tap hashicorp/tap
          ```
          ```sh
          brew install hashicorp/tap/vault
          ```
        - On windows
            ```sh
            choco install vault
            ```
        - On linux
            - Ubuntu/Debian
                ```sh
                sudo apt update && sudo apt install gpg
                ```
            - CentOS/RHEL
                ```sh
                sudo yum install -y yum-utils
                ```
                ```sh
                sudo yum-config-manager --add-repo https://rpm.releases.hashicorp.com/RHEL/hashicorp.repo
                ```
                ```sh
                sudo yum -y install vault
                ```
            - Fedora
                ```sh
                sudo dnf install -y dnf-plugins-core
                ```
                ```sh
                sudo dnf config-manager --add-repo https://rpm.releases.hashicorp.com/fedora/hashicorp.repo
                ```
                ```sh
                sudo dnf -y install vault
                ```
            - Amazon Linux
              ```sh
              sudo yum install -y yum-utils
              ```
              ```sh
              sudo yum-config-manager --add-repo https://rpm.releases.hashicorp.com/AmazonLinux/hashicorp.repo
              ```
              ```sh
              sudo yum -y install vault
              ```
- Start vault
  ```sh
  vault server -dev
  ```