# jwt-projects-subtree

Teste gerenciando sub-repositórios com subtree

## 1. Comandos básicos

### 1.1. Adicionando um sub-repositório

```bash
git remote add <subrepo-remoto> <subrepo-url>

# exemplo
git remoto add jwt-frontend-test https://github.com/khalegjr/jwt-frontend-test.git
```

Esse comando adiciona um repositório na lista de repositórios remotos. Cria um nome para ser usado no lugar da url do repositório.

> [!IMPORTANT]
>
> - *subrepo-remoto*: Nome/atalho para o sub-repositório.
> - *subrepo-url*: Endereço url do sub-repositório.

### 1.2. Criando uma subtree

```bash
git subtree add --prefix <subrepo-path> <subrepo-remoto> main --squash

# exemplo
git subtree add --prefix=frontend jwt-frontend-test main --squash
```

Esse comando cria uma pasta que conterá o código do sub-repositório.

> [!IMPORTANT]
>
> - *subrepo-path*: Diretório onde vai copiar o código do sub-repositório.
> - *subrepo-remoto*: Nome/atalho para o sub-repositório, criado no comando anterior.
> - *branch*:
> - *--squash*: comprime todos os commits em um único commit e faz merge com o repositório container.

### 1.3. Busca todos as alterações de uma subtree

```bash
git subtree pull --prefix <subrepo-path> <subrepo-remoto> main --squash

# exemplo
git subtree pull --prefix=frontend jwt-frontend-test main --squash
```

Esse comando busca todas as mudanças no sub-repositório.

> [!IMPORTANT]
>
> - *subrepo-path*: Diretório do sub-repositório.
> - *subrepo-remoto*: Nome/atalho para o sub-repositório, criado no primeiro comando.
> - *branch*:
> - *--squash*: comprime todos os commits em um único commit e faz merge com o repositório container.

### 1.4. Enviando alterações para uma subtree

```bash
git subtree push --prefix <subrepo-path> <subrepo-remoto> main

# exemplo
git subtree push --prefix=frontend jwt-frontend-test main
```

Esse comando envia as alterações para o sub-repositório.

> [!IMPORTANT]
>
> - *subrepo-path*: Diretório do sub-repositório.
> - *subrepo-remoto*: Nome/atalho para o sub-repositório, criado no primeiro comando.
> - *branch*:

## 2. Fontes

- <https://www.possatti.com.br/git-subtrees/>
- <https://www.atlassian.com/git/tutorials/git-subtree>
- <https://gist.github.com/SKempin/b7857a6ff6bddb05717cc17a44091202>
- <https://www.netways.de/blog/2016/01/14/working-with-git-subtree/>
- <https://opensource.com/article/20/5/git-submodules-subtrees>
