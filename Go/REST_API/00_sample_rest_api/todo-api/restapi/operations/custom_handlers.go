// custom_handlers.go
package operations

import (
    "github.com/go-openapi/runtime/middleware"
    "todo-api/todo-api/models"
)

// List of in-memory ToDos
var todos = []*models.ToDo{
    {ID: int64Ptr(1), Task: stringPtr("Buy milk"), Completed: false},
    {ID: int64Ptr(2), Task: stringPtr("Read book"), Completed: true},
}

// Helper function to create *int64
func int64Ptr(i int64) *int64 {
    return &i
}

// Helper function to create *string
func stringPtr(s string) *string {
    return &s
}

// CustomGetTodosHandler is your implementation for the GetTodos API
func CustomGetTodosHandler(params GetTodosParams) middleware.Responder {
    return NewGetTodosOK().WithPayload(todos)
}