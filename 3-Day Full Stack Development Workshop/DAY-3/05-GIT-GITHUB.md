# Step 5 — Git and GitHub

Git records changes to your project.

GitHub can store the Git repository online.

## Create .gitignore

At project root:

```text
.gitignore
```

Add:

```text
venv/
__pycache__/
*.pyc
db.sqlite3
.env
```

## Why ignore these?

### venv/

This contains installed packages and can be recreated.

### db.sqlite3

For this workshop it contains local student data. It should not be uploaded.

### .env

Environment files often contain secrets.

## Initialize Git

```bash
git init
```

Check:

```bash
git status
```

Add files:

```bash
git add .
```

Commit:

```bash
git commit -m "Build campus task manager"
```

## GitHub

Create an empty repository on GitHub.

Then connect it using the commands GitHub gives you.

Typical commands:

```bash
git branch -M main
git remote add origin YOUR_REPOSITORY_URL
git push -u origin main
```

Do not copy someone else's repository URL.

Use the URL for your own repository.

## Final concept

```text
Your Computer
     |
     | git
     v
Git Repository
     |
     | push
     v
GitHub
```
