# 6. Git & GitHub

Create `.gitignore`:

```gitignore
venv/
__pycache__/
*.pyc
db.sqlite3
.env
.DS_Store
```

The local SQLite database is excluded because it contains local development data.

Initialize Git:

```bash
git init
```

Check:

```bash
git status
```

Commit:

```bash
git add .
git commit -m "Complete Django task manager"
```

Create an empty repository on GitHub and connect it:

```bash
git branch -M main
git remote add origin YOUR_GITHUB_REPOSITORY_URL
git push -u origin main
```

Never commit passwords, API keys or other secrets.
