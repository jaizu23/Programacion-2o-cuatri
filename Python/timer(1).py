import time
import copy
import matplotlib.pyplot as plt

def benchmark(function): 
    """Decorator that reports the execution time"""
    def wrap(*args, **kwargs):
        num_times = 1
        suma = 0
        for _ in range(num_times):
            new_args = copy.deepcopy(args)
            new_kwargs = copy.deepcopy(kwargs)
            start = time.time_ns() / 1e6
            result = function(*new_args, **new_kwargs)
            end = time.time_ns() / 1e6
            suma += end - start
        tiempo_medio = suma / num_times
        # print(f'Elapsed time ({function.__name__}): {tiempo_medio :.3f}s')
        return tiempo_medio
    return wrap
  
@benchmark
def countdown(n): 
    """Counts down"""
    while n > 0: 
        n -= 1

if __name__ == '__main__':
    countdown(100000) # Warmup
    sizes = []
    times = []
    for i in range(100000, 10000000, 1000000):
        sizes += [i]
        times += [countdown(i)]
    plt.plot(sizes, times, label='countdown')
    plt.title('Variación del tiempo en función de n')
    plt.xlabel('Valor de n')
    plt.ylabel('Tiempo de ejecución (ms)')
    plt.legend()
    plt.show()
