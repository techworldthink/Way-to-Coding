# Step 1 — Create the Python Environment

A virtual environment gives this project its own Python packages.

Without it, packages from different projects can interfere with each other.

## Create a folder

```bash
mkdir campus-task-manager
cd campus-task-manager
```

## Create virtual environment

```bash
python -m venv venv
```

If your machine uses `python3`:

```bash
python3 -m venv venv
```

A new `venv` folder should appear.

## Activate it

### Windows Command Prompt

```text
venv\Scripts\activate
```

### Windows PowerShell

```powershell
venv\Scripts\Activate.ps1
```

### Linux/macOS

```bash
source venv/bin/activate
```

Your terminal should now show something similar to:

```text
(venv)
```

## If PowerShell blocks activation

You can use Command Prompt instead, or run PowerShell with an appropriate execution policy for your environment. Do not disable system security blindly.

## Upgrade pip

```bash
python -m pip install --upgrade pip
```

## Install Django

```bash
pip install django
```

## Verify

```bash
django-admin --version
```

You should see a Django version number.

## Save installed packages

```bash
pip freeze > requirements.txt
```

## Important

Every time you work on this project later, activate the environment first.

## Test

Run:

```bash
python -c "import django; print(django.get_version())"
```

If a version appears, Django is installed correctly.

## Common error

### `No module named django`

Usually the virtual environment is not active.

Activate it and run:

```bash
pip install django
```
