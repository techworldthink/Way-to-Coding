# Day 2 Homework

Choose at least one.

## Option A — Search

Add:

```text
Search tasks: [________] [Search]
```

Hint:

```python
query = request.GET.get("q", "")

tasks = tasks.filter(
    title__icontains=query
)
```

## Option B — Priority

Add:

```text
Low
Medium
High
```

and display it as a Bootstrap badge.

## Option C — Category

Add:

```text
Assignment
Project
Personal
Other
```

## Option D — Due Date

Allow users to enter a due date.

## Minimum requirement

Your application must still support:

```text
Create
Read
Update
Delete
Complete
Filter
```
