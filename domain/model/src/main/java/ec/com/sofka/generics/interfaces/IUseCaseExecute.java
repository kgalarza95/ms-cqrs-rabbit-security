package ec.com.sofka.generics.interfaces;

import ec.com.sofka.generics.utils.Command;

//9. Generics creation to apply DDD: IUseCase - Interface to execute use cases
public interface IUseCaseExecute<T extends Command, R> {
    R execute(T request);

}
