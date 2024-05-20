--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3 (Postgres.app)
-- Dumped by pg_dump version 16.3 (Postgres.app)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: alumno; Type: TABLE; Schema: public; Owner: mac
--

CREATE TABLE public.alumno (
    id bigint NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.alumno OWNER TO mac;

--
-- Name: alumno_id_seq; Type: SEQUENCE; Schema: public; Owner: mac
--

CREATE SEQUENCE public.alumno_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.alumno_id_seq OWNER TO mac;

--
-- Name: alumno_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mac
--

ALTER SEQUENCE public.alumno_id_seq OWNED BY public.alumno.id;


--
-- Name: curso; Type: TABLE; Schema: public; Owner: mac
--

CREATE TABLE public.curso (
    id bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    tipo character varying(255) NOT NULL
);


ALTER TABLE public.curso OWNER TO mac;

--
-- Name: curso_id_seq; Type: SEQUENCE; Schema: public; Owner: mac
--

CREATE SEQUENCE public.curso_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.curso_id_seq OWNER TO mac;

--
-- Name: curso_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mac
--

ALTER SEQUENCE public.curso_id_seq OWNED BY public.curso.id;


--
-- Name: inscripcion; Type: TABLE; Schema: public; Owner: mac
--

CREATE TABLE public.inscripcion (
    id bigint NOT NULL,
    aprobado boolean,
    asistencia real,
    calificacion real,
    alumno_id bigint NOT NULL,
    curso_id bigint NOT NULL
);


ALTER TABLE public.inscripcion OWNER TO mac;

--
-- Name: inscripcion_id_seq; Type: SEQUENCE; Schema: public; Owner: mac
--

CREATE SEQUENCE public.inscripcion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.inscripcion_id_seq OWNER TO mac;

--
-- Name: inscripcion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mac
--

ALTER SEQUENCE public.inscripcion_id_seq OWNED BY public.inscripcion.id;


--
-- Name: alumno id; Type: DEFAULT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.alumno ALTER COLUMN id SET DEFAULT nextval('public.alumno_id_seq'::regclass);


--
-- Name: curso id; Type: DEFAULT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.curso ALTER COLUMN id SET DEFAULT nextval('public.curso_id_seq'::regclass);


--
-- Name: inscripcion id; Type: DEFAULT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.inscripcion ALTER COLUMN id SET DEFAULT nextval('public.inscripcion_id_seq'::regclass);


--
-- Data for Name: alumno; Type: TABLE DATA; Schema: public; Owner: mac
--

COPY public.alumno (id, nombre) FROM stdin;
3	Eduardo Ramirez
4	Ismael Garcia
1	Luis Perez
\.


--
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: mac
--

COPY public.curso (id, nombre, tipo) FROM stdin;
1	Matemáticas	mixto
4	Programacion Orientada a Objetos	calificacion
3	Programacion orientada a objetos	calificacion
\.


--
-- Data for Name: inscripcion; Type: TABLE DATA; Schema: public; Owner: mac
--

COPY public.inscripcion (id, aprobado, asistencia, calificacion, alumno_id, curso_id) FROM stdin;
5	f	60	10	3	1
7	t	10	9	3	3
15	t	70	9	1	3
16	t	90	7	4	3
17	f	70	6	4	3
20	t	100	8	3	4
18	t	100	10	1	4
21	t	100	10	4	4
\.


--
-- Name: alumno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mac
--

SELECT pg_catalog.setval('public.alumno_id_seq', 4, true);


--
-- Name: curso_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mac
--

SELECT pg_catalog.setval('public.curso_id_seq', 4, true);


--
-- Name: inscripcion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mac
--

SELECT pg_catalog.setval('public.inscripcion_id_seq', 21, true);


--
-- Name: alumno alumno_pkey; Type: CONSTRAINT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (id);


--
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id);


--
-- Name: inscripcion inscripcion_pkey; Type: CONSTRAINT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT inscripcion_pkey PRIMARY KEY (id);


--
-- Name: inscripcion fk53oy51geundskbmafp223e705; Type: FK CONSTRAINT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT fk53oy51geundskbmafp223e705 FOREIGN KEY (curso_id) REFERENCES public.curso(id);


--
-- Name: inscripcion fkndj1y0din8ba2lkfntabm6476; Type: FK CONSTRAINT; Schema: public; Owner: mac
--

ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT fkndj1y0din8ba2lkfntabm6476 FOREIGN KEY (alumno_id) REFERENCES public.alumno(id);


--
-- PostgreSQL database dump complete
--

