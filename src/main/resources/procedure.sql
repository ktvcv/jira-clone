CREATE OR REPLACE PROCEDURE delete_all_by_date(p_date IN date)
AS $$
BEGIN
    IF p_date IS NOT NULL THEN
        UPDATE history
        SET delete_date = p_date
        WHERE delete_date < p_date;
        COMMIT;
    END IF;
END;$$
    LANGUAGE plpgsql