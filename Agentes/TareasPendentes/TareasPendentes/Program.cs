// Agente de Tareas
public class TaskAgent
{
    public event Action<string> TaskNotification;

    public void CheckTasks(List<string> tasks)
    {
        foreach (var task in tasks)
        {
            if (IsTaskPending(task))
            {
                TaskNotification?.Invoke(task);
            }
        }
    }

    private bool IsTaskPending(string task)
    {
        // Simulación de verificación de tarea pendiente
        return true; // Supongamos que todas las tareas están pendientes para este ejemplo
    }
}

// Agente de Usuario
public class UserAgent
{
    public void ReceiveNotification(string task)
    {
        Console.WriteLine($"Agente: Tiene la siguiente tarea pendiente: {task}");
    }
}

class Program
{
    static void Main(string[] args)
    {
        var taskAgent = new TaskAgent();
        var userAgent = new UserAgent();

        // Configurar evento
        taskAgent.TaskNotification += userAgent.ReceiveNotification;

        // Simular lista de tareas pendientes
        var tasks = new List<string> { "Tarea 1", "Tarea 2", "Tarea 3" };
        taskAgent.CheckTasks(tasks);

        // Mantener la aplicación abierta
        Console.ReadLine();
    }
}

