package subway.controller;

public abstract class ManageController extends Controller {
    protected abstract void create();

    protected abstract void delete();

    protected abstract void read();
}
